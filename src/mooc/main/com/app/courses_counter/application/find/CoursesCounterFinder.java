package com.app.courses_counter.application.find;

import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.CoursesCounterNotInitialized;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import com.app.courses_counter.domain.value.CoursesCounterId;
import com.app.courses_counter.domain.value.CoursesCounterTotal;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
public class CoursesCounterFinder {

    private final CoursesCounterSearchRepository repository;

    public Long find(){

        CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
            throw new CoursesCounterNotInitialized();
        });
//        CoursesCounter coursesCounter = repository.search().orElse(
//                new CoursesCounter(new CoursesCounterId(UUID.randomUUID().toString()),
//                new CoursesCounterTotal(0L), new ArrayList<>()));

        return  coursesCounter.getTotal().value();
    }
}
