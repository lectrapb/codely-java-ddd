package com.app.infraestructure.bus.event.mysql;

import com.app.domain.bus.DomainEvent;
import com.app.infraestructure.bus.event.DomainEventsInformation;
import com.app.infraestructure.bus.event.mysql.domain.DomainEventData;
import com.app.infraestructure.bus.event.mysql.infra.JPAEventBusRepository;
import com.app.infraestructure.bus.event.spring.SpringApplicationEventBus;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
@Service
public class MySqlDomainEventsConsumer {

    private final JPAEventBusRepository eventBusRepository;
    private final DomainEventsInformation domainEventsInformation;
    private final Integer CHUNKS = 200;
    private final SpringApplicationEventBus bus;

    @SneakyThrows
    @Transactional
    public void consume() {


        var all = eventBusRepository.findFirstN(CHUNKS);
        if (!all.isEmpty())
            for (DomainEventData data : all) {
                executeSubscribers(data.getId(), data.getAggregateId(),
                        data.getName(), data.getBody(), data.getOccurredOn());
            }

    }

    private void executeSubscribers(
            String id, String aggregateId, String eventName, Map<String, Serializable> body, String occurredOn
    ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<? extends DomainEvent> domainEventClass = domainEventsInformation.forName(eventName);

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();


        Method fromPrimitivesMethod = domainEventClass.getMethod(
                "fromPrimitives",
                String.class,
                Map.class,
                String.class,
                String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
                nullInstance,
                aggregateId,
                body,
                id,
                occurredOn
        );
        bus.publish(Collections.singletonList((DomainEvent<?>) domainEvent));
    }
}
