package com.app.infraestructure.bus.event;


import com.app.domain.JsonSerializer;
import com.app.domain.bus.event.DomainEvent;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Service
public class DomainEventJsonDeserializer {

    private final DomainEventsInformation information;

    public DomainEventJsonDeserializer(DomainEventsInformation information) {
        this.information = information;
    }

    public DomainEvent<?> deserialize(String body) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Map<String, Serializable> eventData = JsonSerializer.jsonDecode(body);
        if(eventData != null){
            Map<String, Serializable> data = (Map<String, Serializable>) eventData.get("data");
            Map<String, Serializable> attributes = (Map<String, Serializable>)  data.get("attributes");
            Class<? extends DomainEvent> domainEventClass = information.forName((String) data.get("type"));

            DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

            Method fromPrimitivesMethod = domainEventClass.getMethod(
                    "fromPrimitives",
                    String.class,
                    Map.class,
                    String.class,
                    String.class
            );

            Object domainEvent = fromPrimitivesMethod.invoke(
                    nullInstance,
                    (String) attributes.get("id"),
                    attributes,
                    (String) data.get("id"),
                    (String) data.get("occurred_on")
            );

            return (DomainEvent<?>) domainEvent;
        }else {
            return null;
        }

    }




}