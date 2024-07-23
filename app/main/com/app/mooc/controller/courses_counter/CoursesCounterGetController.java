package com.app.mooc.controller.courses_counter;

import com.app.courses_counter.application.find.CoursesCounterFinder;
import com.app.courses_counter.application.find.CoursesCounterResponse;
import com.app.courses_counter.application.find.FindCoursesCounterQuery;
import com.app.domain.bus.query.QueryBus;
import com.app.domain.bus.query.QueryNotRegisteredError;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CoursesCounterGetController {

    private QueryBus bus;

    @GetMapping("/courses-counter")
    public ResponseEntity<Map<String, Long>> index() throws QueryNotRegisteredError {


         CoursesCounterResponse response =  bus.ask(new FindCoursesCounterQuery());
         Map<String, Long> data = new HashMap<>();
         data.put("total", response.getTotal());
         return  ResponseEntity.ok(data);
    }
}
