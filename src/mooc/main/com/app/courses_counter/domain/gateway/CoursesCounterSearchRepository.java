package com.app.courses_counter.domain.gateway;

import com.app.courses_counter.domain.CoursesCounter;

import java.util.Optional;

public interface CoursesCounterSearchRepository {

    Optional<CoursesCounter> search();
}
