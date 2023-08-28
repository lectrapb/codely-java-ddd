package com.app.courses_counter.infraestructure.database.application;

import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import com.app.courses_counter.domain.value.CoursesCounterId;
import com.app.courses_counter.domain.value.CoursesCounterTotal;
import com.app.courses_counter.infraestructure.database.infra.JPACourseCounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseCounterSearchAdapter implements CoursesCounterSearchRepository {

    private final JPACourseCounterRepository repository;

    @Override
    public Optional<CoursesCounter> search() {
        var countersData = repository.findAll();
        if(!countersData.isEmpty() ){
            var data = countersData.get(0);
            return Optional.of(new CoursesCounter(new CoursesCounterId(data.getId()),
                    new CoursesCounterTotal(data.getTotal()), new ArrayList<>()));
        }
        return Optional.empty();
    }
}
