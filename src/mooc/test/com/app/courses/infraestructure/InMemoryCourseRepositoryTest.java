package com.app.courses.infraestructure;

import com.app.courses.domain.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {

    private InMemoryCourseRepository repository;

    @BeforeEach
    void setUp(){
        repository = new InMemoryCourseRepository();
    }
    @Test
    void save_a_valid_course() {

        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course()  {
        //given
        var course = new Course("some-id", "some-name", "some-duration");
        //when
        repository.save(course);
        var result = repository.search("some-id");
        //Then
        assertEquals(course, result.get());
    }

    @Test
    void not_find_a_non_existing_course() {
        //given
        var course = new Course("some-id", "some-name", "some-duration");
        //Then
        assertNotEquals(Optional.of(course), repository.search("some-id1"));
    }


}