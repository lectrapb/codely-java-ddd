package com.app.mooc.controller.courses_counter;

import com.app.courses_counter.application.find.CoursesCounterFinder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CoursesCounterGetController {

    private final CoursesCounterFinder finder;

    @GetMapping("/courses-counter")
    public ResponseEntity<Map<String, Long>> index(){

         var response = finder.find();
         Map<String, Long> data = new HashMap<>();
         data.put("total", response);
         return  ResponseEntity.ok(data);
    }
}
