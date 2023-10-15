package com.app.infraestructure.bus.event;

import com.app.domain.bus.DomainEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

@Service
public class DomainEventsInformation {

    Map<String, Class<? extends DomainEvent>> indexedDomainEvents;

    public DomainEventsInformation() {

        var reflections = new Reflections("com.app");
        Set<Class<? extends DomainEvent>> classes = reflections.getSubTypesOf(DomainEvent.class);
        try {
            indexedDomainEvents = formatEvents(classes);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Class<? extends DomainEvent> forName(String name) {
        return indexedDomainEvents.get(name);
    }

    private Map<String, Class<? extends DomainEvent>> formatEvents(
            Set<Class<? extends DomainEvent>> domainEvents) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Map<String, Class<? extends DomainEvent>> events = new HashMap<>();

        for (Class<? extends DomainEvent> domainEvent : domainEvents) {
            DomainEvent nullInstance = domainEvent.getConstructor().newInstance();

            events.put((String) domainEvent.getMethod("eventName").invoke(nullInstance), domainEvent);
        }

        return events;
    }

    public String forClass(Class<? extends DomainEvent<?>> domainEventClass) {
        return indexedDomainEvents.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), domainEventClass))
                .map(Map.Entry::getKey)
                .findFirst().orElse("");
    }
}
