package com.app.courses.domain.gateway;

import com.app.courses.domain.Course;

import java.util.Optional;

public interface CourseRepository {

      public void save(Course course);

      Optional<Course> search(String id);
}
