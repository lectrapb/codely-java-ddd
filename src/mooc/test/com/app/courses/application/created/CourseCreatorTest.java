package com.app.courses.application.created;

import com.app.courses.domain.gateway.CourseRepository;
import com.app.courses.domain.CreateCourseRequestMother;
import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.domain.bus.event.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.*;

class CourseCreatorTest {

    private CourseRepository repository;
    private EventBus eventBus;
    private CourseCreator useCase;
    @BeforeEach
    void setUp() {
        repository = mock(CourseRepository.class);
        eventBus = mock(EventBus.class);
        useCase = new CourseCreator(repository, eventBus);
    }

    @Test
    void create_a_valid_course() {
        //given
        var course = CreateCourseRequestMother.random();
        //when
        doNothing().when(repository).save(any());
        doNothing().when(eventBus).publish(any());
        useCase.create(new CourseId(UUID.randomUUID().toString()), new CourseName("test"),
                new CourseDuration(new Date().toString()));
        //then
        verify(repository, atLeastOnce())
                .save(any());
        verify(eventBus, atLeastOnce())
                .publish(any());
    }
}