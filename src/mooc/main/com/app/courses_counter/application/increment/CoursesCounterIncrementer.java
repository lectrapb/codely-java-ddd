package com.app.courses_counter.application.increment;

import com.app.courses.domain.value.CourseId;
import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CoursesCounterIncrementer {

    private final CoursesCounterSaveRepository saveRepository;
    private final CoursesCounterSearchRepository searchRepository;

    public void increment(CourseId id){
        CoursesCounter counter = searchRepository.search()
                .orElseGet(() -> CoursesCounter.initialize(UUID.randomUUID().toString()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);
            saveRepository.save(counter);
        }
    }
}
