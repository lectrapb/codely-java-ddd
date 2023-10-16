package com.app.infraestructure.bus.event.rabbit;

import com.app.domain.bus.event.DomainEvent;
import com.app.domain.bus.event.EventBus;
import com.app.infraestructure.bus.event.DomainEventJsonSerializer;
import com.app.infraestructure.bus.event.mysql.MySqlEventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@Primary
public class RabbitMqEventBus implements EventBus {

    private final RabbitTemplate rabbitTemplate;
    private final MySqlEventBus failoverPublisher;
    private final String exchangeName;

    public RabbitMqEventBus(RabbitTemplate rabbitTemplate, MySqlEventBus failoverPublisher) {
        this.rabbitTemplate = rabbitTemplate;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent<?> domainEvent) {

        try {
            String serializedDomainEvent = DomainEventJsonSerializer.serialize(domainEvent);

            Message message = new Message(
                    serializedDomainEvent.getBytes(),
                    MessagePropertiesBuilder.newInstance()
                            .setContentEncoding("utf-8")
                            .setContentType("application/json")
                            .build()
            );

            rabbitTemplate.send(exchangeName, domainEvent.eventName(), message);
        } catch (AmqpException error) {
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }


}
