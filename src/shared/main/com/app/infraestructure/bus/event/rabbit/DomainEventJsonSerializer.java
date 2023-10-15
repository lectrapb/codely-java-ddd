package com.app.infraestructure.bus.event.rabbit;

import com.app.domain.JsonSerializer;
import com.app.domain.bus.DomainEvent;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class DomainEventJsonSerializer {

    public static String serialize(DomainEvent<?> domainEvent) {
        HashMap<String, Serializable> attributes = (HashMap<String, Serializable> )domainEvent.toPrimitives();
        attributes.put("id", domainEvent.aggregateId());

        Gson gson = new Gson();
        HashMap<String, Serializable> data = new HashMap<>() {{
            put("data", new HashMap<String, Serializable>() {{
                put("id", domainEvent.eventId());
                put("type", domainEvent.eventName());
                put("occurred_on", domainEvent.occurredOn());
                put("attributes", attributes);
            }});
            put("meta", new HashMap<String, Serializable>());
        }};

        return JsonSerializer.jsonEncode(data);
    }
}
