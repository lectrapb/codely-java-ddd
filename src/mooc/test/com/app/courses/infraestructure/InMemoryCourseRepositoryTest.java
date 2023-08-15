package com.app.courses.infraestructure;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseDuration;
import com.app.courses.domain.CourseId;
import com.app.courses.domain.CourseName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {

    private InMemoryCourseRepository repository;
    private static final String UID = UUID.randomUUID().toString();

    @BeforeEach
    void setUp(){
        repository = new InMemoryCourseRepository();
    }
    @Test
    void save_a_valid_course() {

        repository.save(getCourse());
    }

    private static Course getCourse() {
        return new Course(new CourseId(UID), new CourseName("some-name"),
                new CourseDuration("some-duration"));
    }

    @Test
    void search_an_existing_course()  {
        //given
        var course = getCourse();
        //when
        repository.save(course);
        var result = repository.search(UID);
        //Then
        assertEquals(course, result.get());
    }

    @Test
    void not_find_a_non_existing_course() {
        //given
        var course = getCourse();
        //Then
        assertNotEquals(Optional.of(course), repository.search("some-id1"));
    }


}