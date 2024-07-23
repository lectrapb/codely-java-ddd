package com.app.courses.application.created;

import com.app.courses.domain.*;
import com.app.courses.domain.gateway.CourseRepository;
import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.domain.bus.event.EventBus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CourseCreator {


    private final CourseRepository courseRepository;
    private final EventBus eventBus;

    public void create( CourseId id, CourseName name, CourseDuration duration) {

        var course = Course.create(id, name, duration);

        courseRepository.save(course);
        var result = course.pullDomainEvents();

        eventBus.publish(course.pullDomainEvents());
    }
}
