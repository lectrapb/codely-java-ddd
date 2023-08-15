package com.app.courses.application.created;

import com.app.courses.domain.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CourseCreator {


    private final CourseRepository courseRepository;
    public void create (CreateCourseRequest request){

            var course = new Course(new CourseId(request.getId()), new CourseName(request.getName()),
                    new CourseDuration(request.getDuration()));
            courseRepository.save(course);
    }
}
