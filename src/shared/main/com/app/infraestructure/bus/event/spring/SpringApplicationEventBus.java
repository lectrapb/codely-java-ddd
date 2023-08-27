package com.app.infraestructure.bus.event.spring;

import com.app.domain.bus.DomainEvent;
import com.app.domain.bus.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;
    @Override
    public void publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent<?> event) {
        this.publisher.publishEvent(event);
    }
}
