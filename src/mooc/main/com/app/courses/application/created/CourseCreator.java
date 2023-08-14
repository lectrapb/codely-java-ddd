package com.app.courses.application.created;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CourseCreator {


    private final CourseRepository courseRepository;
    public void create (CreateCourseRequest request){

            var course = new Course(request.getId(), request.getName(),
                    request.getDuration());
            courseRepository.save(course);
    }
}
