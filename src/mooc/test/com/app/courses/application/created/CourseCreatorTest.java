package com.app.courses.application.created;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        var course = new Course("some-id", "some-name", "some-duration");
        //when
        doNothing().when(repository).save(any());
        useCase.create(new CreateCourseRequest(course.id(), course.name(), course.duration()));
        //then
        verify(repository, atLeastOnce()).save(any());
    }
}