package com.app.infraestructure.bus.event.rabbit;

import com.app.infraestructure.bus.event.DomainEventSubscriber;
import com.app.infraestructure.bus.event.DomainEventSubscriberInformation;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Service
public class DomainEventSubscribersInformation {

    HashMap<Class<?>, DomainEventSubscriberInformation> information;

    public DomainEventSubscribersInformation() {
        Reflections reflections = new Reflections("com.app");
        Set<Class<?>> classes     = reflections.getTypesAnnotatedWith(DomainEventSubscriber.class);

        information = formatSubscribers(classes);
    }

    public Collection<DomainEventSubscriberInformation> all() {
        return information.values();
    }

    public String[] rabbitMqFormattedNames() {
        return information.values()
                .stream()
                .map(DomainEventSubscriberInformation::formatRabbitMqQueueName)
                .distinct()
                .toArray(String[]::new);
    }

    private HashMap<Class<?>, DomainEventSubscriberInformation> formatSubscribers(Set<Class<?>> subscribers) {
        HashMap<Class<?>, DomainEventSubscriberInformation> subscribersInformation = new HashMap<>();

        for (Class<?> subscriberClass : subscribers) {
            DomainEventSubscriber annotation = subscriberClass.getAnnotation(DomainEventSubscriber.class);

            subscribersInformation.put(
                    subscriberClass,
                    new DomainEventSubscriberInformation(subscriberClass, Arrays.asList(annotation.value()))

            );
        }

        return subscribersInformation;
    }


}
