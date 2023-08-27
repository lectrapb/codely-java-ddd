package com.app.courses.application.created;

import com.app.courses.domain.*;
import com.app.courses.domain.gateway.CourseRepository;
import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.domain.bus.EventBus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CourseCreator {


    private final CourseRepository courseRepository;
    private final EventBus eventBus;
    public void create (CreateCourseRequest request){

            var course = new Course(new CourseId(request.getId()), new CourseName(request.getName()),
                    new CourseDuration(request.getDuration()));

            courseRepository.save(course);

            eventBus.publish(course.pullDomainEvents());
    }
}
