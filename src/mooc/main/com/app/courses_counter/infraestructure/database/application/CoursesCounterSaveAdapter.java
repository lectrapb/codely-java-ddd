package com.app.courses_counter.infraestructure.database.application;

import com.app.courses.domain.value.CourseId;
import com.app.courses_counter.domain.CoursesCounter;
import com.app.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import com.app.courses_counter.infraestructure.database.domain.CoursesCounterData;
import com.app.courses_counter.infraestructure.database.infra.JPACourseCounterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CoursesCounterSaveAdapter implements CoursesCounterSaveRepository {

    private final JPACourseCounterRepository repository;
    @Override
    public void save(CoursesCounter courseCount) {

         var counterData = new CoursesCounterData();
         counterData.setId(courseCount.getId().value());
         counterData.setTotal(courseCount.getTotal().value());
         var list =  courseCount.getExistingCourses();
         Map<String,String> map = new HashMap<>(list.size());
         for (CourseId i : list) map.put(i.value(),i.value());
         counterData.setData(map);
         repository.save(counterData);
    }
}
