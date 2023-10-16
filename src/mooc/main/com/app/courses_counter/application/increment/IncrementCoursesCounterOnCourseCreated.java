package com.app.courses_counter.application.increment;

import com.app.courses.domain.events.CourseCreatedDomainEvent;
import com.app.courses.domain.value.CourseId;
import com.app.domain.bus.event.DomainEventSubscriber;
import lombok.AllArgsConstructor;

//java-ddd/src/mooc/main/com/app/courses_counter/application/increment/IncrementCoursesCounterOnCourseCreated.java
@AllArgsConstructor
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public class IncrementCoursesCounterOnCourseCreated {

    private final CoursesCounterIncrementer incrementer;

    //@EventListener
    public void on(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());

        incrementer.increment(courseId);
    }
}
