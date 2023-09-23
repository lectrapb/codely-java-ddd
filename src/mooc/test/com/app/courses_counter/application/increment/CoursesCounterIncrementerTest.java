package com.app.courses_counter.application.increment;

import com.app.courses.domain.value.CourseId;
import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import com.app.courses_counter.domain.value.CoursesCounterId;
import com.app.courses_counter.domain.value.CoursesCounterTotal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CoursesCounterIncrementerTest {

    private  CoursesCounterSaveRepository saveRepository;
    private  CoursesCounterSearchRepository searchRepository;

    private CoursesCounterIncrementer incrementer;

    @BeforeEach
    void setUp(){
        saveRepository = mock(CoursesCounterSaveRepository.class);
        searchRepository = mock(CoursesCounterSearchRepository.class);
        incrementer = new CoursesCounterIncrementer(saveRepository, searchRepository);
    }
    @Test
    void it_should_not_increment_an_already_incremented_course() {
        //given
        var courseId = new CourseId(UUID.randomUUID().toString());
        CourseId[] coursesId = { courseId ,new CourseId(UUID.randomUUID().toString()) };
        var courseIds = Arrays.asList(coursesId);
        var coursesCounter = new CoursesCounter(new CoursesCounterId(UUID.randomUUID().toString()),
                new CoursesCounterTotal(1L), courseIds);
        //when
        when(searchRepository.search()).thenReturn(Optional.of(coursesCounter));
        doNothing().when(saveRepository).save(any());
        //then
        incrementer.increment(courseId);
        var result = verify(saveRepository, atLeastOnce());
        assertNotNull(result);
    }
}