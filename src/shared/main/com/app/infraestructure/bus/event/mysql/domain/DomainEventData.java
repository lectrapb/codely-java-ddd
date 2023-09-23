package com.app.infraestructure.bus.event.mysql.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.io.Serializable;
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
