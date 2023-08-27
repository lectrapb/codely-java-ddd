package com.app.courses.domain.events;

import com.app.domain.bus.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CourseCreatedDomainEvent extends DomainEvent<CourseCreatedDomainEvent> {

    private String name;
    private String duration;

    public CourseCreatedDomainEvent(String aggregateId, String name, String duration) {
        super(aggregateId);

        this.name = name;
        this.duration = duration;
    }

    public CourseCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String name,
            String duration
    ) {
        super(aggregateId, eventId, occurredOn);

        this.name     = name;
        this.duration = duration;
    }

    @Override
    public String eventName() {
        return "course created";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        Map<String, Serializable> response = new HashMap<>();
        response.put("name", name);
        response.put("duration", duration);
        return response;
    }

    @Override
    public CourseCreatedDomainEvent fromPrimitives(
            String aggregateId,
            Map<String, Serializable> body,
            String eventId,
            String occurredOn) {

        return new CourseCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("duration")
        );
    }
}
