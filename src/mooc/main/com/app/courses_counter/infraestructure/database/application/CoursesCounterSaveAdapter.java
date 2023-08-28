package com.app.courses_counter.infraestructure.database.application;

import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import com.app.courses_counter.infraestructure.database.domain.CoursesCounterData;
import com.app.courses_counter.infraestructure.database.infra.JPACourseCounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoursesCounterSaveAdapter implements CoursesCounterSaveRepository {

    private final JPACourseCounterRepository repository;
    @Override
    public void save(CoursesCounter courseCount) {

         var counterData = new CoursesCounterData();
         counterData.setId(courseCount.getId().value());
         counterData.setTotal(courseCount.getTotal().value());
         repository.save(counterData);
    }
}
