package com.app.courses.domain;

import java.util.Objects;

public record Course(CourseId id, CourseName name, CourseDuration duration) {


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
