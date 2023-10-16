package com.app.infraestructure.bus.event;

import com.app.domain.JsonSerializer;
import com.app.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final  class DomainEventJsonSerializer {


    private DomainEventJsonSerializer() {
    }

    public static String serialize(DomainEvent<?> domainEvent) {
        HashMap<String, Serializable> attributes = (HashMap<String, Serializable>)domainEvent.toPrimitives();
        attributes.put("id", domainEvent.aggregateId());

     return JsonSerializer.jsonEncode(new HashMap<String, Serializable>() {{
            put("data", new HashMap<String, Serializable>() {{
                put("id", domainEvent.eventId());
                put("type", domainEvent.eventName());
                put("occurred_on", domainEvent.occurredOn());
                put("attributes", attributes);
            }});
            put("meta", new HashMap<String, Serializable>());
        }});
    }


}
