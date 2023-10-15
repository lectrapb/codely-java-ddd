package com.app.infraestructure.bus.event;

import com.app.domain.bus.DomainEvent;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomainEventSubscriber {

    Class<? extends DomainEvent<?>>[] value();
}
