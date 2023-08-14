package com.app.courses.domain;

import lombok.Getter;
public record Course(String id, String name, String duration) {



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return id.equals(course.id) &&
                name.equals(course.name) &&
                duration.equals(course.duration);
    }
}
