package com.app.domain.bus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent<T extends DomainEvent<?>> {

    private String aggregateId;
    private String eventId;
    private String occurredOn;


    public DomainEvent(String aggregateId) {
        this.aggregateId  = aggregateId;
        this.eventId      = UUID.randomUUID().toString();
        this.occurredOn   = LocalDateTime.now().toString();
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId     = eventId;
        this.occurredOn  = occurredOn;
    }

    public abstract String eventName();
    public abstract Map<String, Serializable> toPrimitives();
    public abstract T fromPrimitives(
            String aggregateId,
            Map<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }


}
