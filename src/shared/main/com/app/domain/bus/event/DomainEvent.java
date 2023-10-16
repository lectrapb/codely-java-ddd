package com.app.domain.bus.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent<T extends DomainEvent<?>> {

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss:SSSSSSSSS";
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private String aggregateId;
    private String eventId;
    private String occurredOn;


    protected DomainEvent() {
    }

    public DomainEvent(String aggregateId) {

        this.aggregateId  = aggregateId;
        this.eventId      = UUID.randomUUID().toString();
        this.occurredOn   = timeFormatter.format(LocalDateTime.now());;
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
