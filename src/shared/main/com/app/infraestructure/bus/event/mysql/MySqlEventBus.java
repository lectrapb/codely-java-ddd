package com.app.infraestructure.bus.event.mysql;

import com.app.domain.bus.DomainEvent;
import com.app.domain.bus.EventBus;
import com.app.infraestructure.bus.event.mysql.domain.DomainEventData;
import com.app.infraestructure.bus.event.mysql.infra.JPAEventBusRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Primary
@Service
@AllArgsConstructor
public class MySqlEventBus implements EventBus {

    private final JPAEventBusRepository eventBusRepository;

    @Override
    public void publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent<?> domainEvent) {

        var id          = domainEvent.eventId();
        var aggregateId = domainEvent.aggregateId();
        var name        = domainEvent.eventName();
        var body = domainEvent.toPrimitives();
        var occurredOn  = domainEvent.occurredOn();

        var domainEventData = new DomainEventData();
        domainEventData.setId(id);
        domainEventData.setAggregateId(aggregateId);
        domainEventData.setName(name);
        domainEventData.setBody(body);
        domainEventData.setOccurredOn(occurredOn);

        eventBusRepository.save(domainEventData);
    }
}
