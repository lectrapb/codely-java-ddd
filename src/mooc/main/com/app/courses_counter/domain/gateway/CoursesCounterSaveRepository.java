package com.app.courses_counter.domain.gateway;

import com.app.courses_counter.domain.CoursesCounter;


public interface CoursesCounterSaveRepository {

    void save(CoursesCounter coursesCounter);
}
