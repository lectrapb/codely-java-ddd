package com.app.courses_counter.application.find;

import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.CoursesCounterNotInitialized;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoursesCounterFinder {

    private final CoursesCounterSearchRepository repository;

    public CoursesCounterResponse find(){

        CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
            throw new CoursesCounterNotInitialized();
        });

        return  new CoursesCounterResponse(coursesCounter.getTotal().value());
    }
}
