package com.app.courses.domain;

import com.app.courses.domain.events.CourseCreatedDomainEvent;
import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.domain.AggregateRoot;

import java.util.Objects;


public class Course extends AggregateRoot {

    private final CourseId id;
    private final CourseName name;
    private final CourseDuration duration;

    public static Course create(CourseId id, CourseName name, CourseDuration duration){

        var course = new Course(id, name, duration);
        course.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value()));
        return course;
    }


    public  Course(CourseId id, CourseName name, CourseDuration duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public CourseId id() {
        return id;
    }

    public CourseName name() {
        return name;
    }

    public CourseDuration duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.value().equals(course.id.value()) && name.value().equals(course.name.value())
                && duration.value().equals(course.duration.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
