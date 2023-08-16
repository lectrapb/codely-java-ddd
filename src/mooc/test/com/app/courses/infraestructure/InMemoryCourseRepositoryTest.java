package com.app.courses.infraestructure;

import com.app.courses.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest extends CourseModuleInfrastructureTestCase {

    private InMemoryCourseRepository repository;


    @BeforeEach
    void setUp() {
        repository = new InMemoryCourseRepository();
    }

    @Test
    void save_a_valid_course() {

        repository.save(CourseMother.random());
    }

    @Test
    void search_an_existing_course() {
        //given
        var course = CourseMother.random();
        //when
        repository.save(course);
        var result = repository.search(course.id().value());
        //Then
        assertEquals(course, result.get());
    }

    @Test
    void not_find_a_non_existing_course() {
        //given
        var course = CourseMother.random();
        //Then
        assertNotEquals(Optional.of(course), repository.search("some-id1"));
    }


}