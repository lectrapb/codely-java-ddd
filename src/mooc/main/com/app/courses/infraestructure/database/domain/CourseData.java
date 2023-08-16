package com.app.courses.infraestructure.database.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CourseData {

    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private String duration;
}
