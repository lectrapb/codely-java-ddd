package com.app.courses.application.created;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CourseCreator {


    private final CourseRepository courseRepository;
    public void create (String id, String name, String duration){

            var course = new Course(id, name, duration);
            courseRepository.save(course);
    }
}
