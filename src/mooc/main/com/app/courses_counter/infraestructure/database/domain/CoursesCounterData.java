package com.app.courses_counter.infraestructure.database.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "courses_counter")
@Data
public class CoursesCounterData {

    @Id
    @Column(name = "courses_counter_id")
    private String  id;
    @Column(name="courses_counter_total")
    private Long total;
    @Type(JsonType.class)
    @Column(columnDefinition = "json", name = "course_list")
    private Map<String, String> data = new HashMap<>();



}
