package com.app.courses.application.created;

import com.app.courses.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class CourseCreatorTest {

    private CourseRepository repository;
    private CourseCreator useCase;
    @BeforeEach
    void setUp() {
        repository = mock(CourseRepository.class);
        useCase = new CourseCreator(repository);
    }

    @Test
    void create() {
        //given
        var course = new Course( new CourseId(UUID.randomUUID().toString()), new CourseName("some-name"),
                new CourseDuration("some-duration"));
        //when
        doNothing().when(repository).save(any());
        useCase.create(new CreateCourseRequest(course.id().value(), course.name().value(),
                course.duration().value()));
        //then
        verify(repository, atLeastOnce()).save(any());
    }
}