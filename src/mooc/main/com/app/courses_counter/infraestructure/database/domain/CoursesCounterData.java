package com.app.courses_counter.infraestructure.database.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "courses_counter")
@Data
public class CoursesCounterData {

    @Id
    @Column(name = "courses_counter_id")
    private String  id;
    @Column(name="courses_counter_total")
    private Long total;
}
