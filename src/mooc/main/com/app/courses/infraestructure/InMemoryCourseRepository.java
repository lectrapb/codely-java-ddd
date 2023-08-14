package com.app.courses.infraestructure;


import org.springframework.stereotype.Repository;
import com.app.courses.domain.Course;
import com.app.courses.domain.CourseRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCourseRepository implements CourseRepository {

    private Map<String, Course> courses = new HashMap<>();
    @Override
    public void save(Course course) {
        this.courses.put(course.id() , course);
    }

    @Override
    public Optional<Course> search(String id) {
        return Optional.ofNullable(courses.get(id));
    }
}
