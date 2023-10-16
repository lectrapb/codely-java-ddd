package com.app.domain.bus.event;

import com.app.domain.bus.event.DomainEvent;

import java.util.List;

public interface EventBus {

    void publish(final List<DomainEvent<?>> events);
}
