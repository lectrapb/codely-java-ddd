package com.app.infraestructure.bus.event;

import com.app.domain.bus.event.DomainEvent;
import com.google.common.base.CaseFormat;


import java.util.List;


public class DomainEventSubscriberInformation {

    private  List<Class<? extends DomainEvent<?>>> subscribedEvents;
    private  Class<?> subscriberClass;

    public DomainEventSubscriberInformation(
            Class<?> subscriberClass,
            List<Class<? extends DomainEvent<?>>> subscribedEvents
    ) {
        this.subscriberClass = subscriberClass;
        this.subscribedEvents = subscribedEvents;
    }

    public Class<?> subscriberClass() {
        return subscriberClass;
    }

    public String contextName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[2];
    }

    public String moduleName() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[3];
    }

    public String className() {
        String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[nameParts.length - 1];
    }

    public List<Class<? extends DomainEvent<?>>> subscribedEvents() {
        return subscribedEvents;
    }

    public String formatRabbitMqQueueName() {
        return String.format("app.%s.%s.%s", contextName(), moduleName(), toSnake(className()));
    }

    private static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }
}
