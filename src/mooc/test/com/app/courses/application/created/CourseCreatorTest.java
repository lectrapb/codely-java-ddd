package com.app.courses.application.created;

import com.app.courses.domain.CourseRepository;
import com.app.courses.domain.CreateCourseRequestMother;
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
    void create_a_valid_course() {
        //given
        var course = CreateCourseRequestMother.random();
        //when
        doNothing().when(repository).save(any());
        useCase.create(course);
        //then
        verify(repository, atLeastOnce())
                .save(any());
    }
}