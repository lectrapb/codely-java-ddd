package com.app.infraestructure.bus.event.mysql.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "domain_events")
@Data
public class DomainEventData {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "aggregate_id")
    private String aggregateId;
    @Column(name = "name")
    private String name;

    @Type(JsonType.class)
    @Column(columnDefinition = "json", name = "body")
    private Map<String, Serializable> body = new HashMap<>();
    @Column(name = "occurred_on")
    private String occurredOn;
}
