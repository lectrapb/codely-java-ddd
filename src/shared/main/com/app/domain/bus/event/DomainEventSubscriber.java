package com.app.domain.bus.event;

import com.app.domain.bus.event.DomainEvent;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomainEventSubscriber {

    Class<? extends DomainEvent<?>>[] value();
}
