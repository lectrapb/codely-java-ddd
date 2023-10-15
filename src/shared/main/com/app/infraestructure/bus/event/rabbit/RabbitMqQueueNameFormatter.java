package com.app.infraestructure.bus.event.rabbit;

import com.app.infraestructure.bus.event.DomainEventSubscriberInformation;
import com.google.common.base.CaseFormat;

public final class RabbitMqQueueNameFormatter {

    private RabbitMqQueueNameFormatter() {
    }

    public static String format(DomainEventSubscriberInformation information) {
        return String.format(
                "app.%s.%s.%s",
                information.contextName(),
                information.moduleName(),
                toSnake(information.className())
        );
    }

    public static String formatRetry(DomainEventSubscriberInformation information) {
        return String.format("retry.%s", format(information));
    }

    public static String formatDeadLetter(DomainEventSubscriberInformation information) {
        return String.format("dead_letter.%s", format(information));
    }

    private static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }
}
