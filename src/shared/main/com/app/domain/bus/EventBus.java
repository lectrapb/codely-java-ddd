package com.app.domain.bus;

import java.util.List;

public interface EventBus {

    void publish(final List<DomainEvent<?>> events);
}
