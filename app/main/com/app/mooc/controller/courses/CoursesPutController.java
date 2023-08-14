package com.app.mooc.controller.courses;

import com.app.courses.application.created.CourseCreator;
import com.app.courses.application.created.CreateCourseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CoursesPutController {

    private final CourseCreator courseCreator;

    @PutMapping("/courses/{id}")
    public ResponseEntity created(@PathVariable String id,
                                  @RequestBody Request request) {

        courseCreator.create(new CreateCourseRequest(id, request.getName(), request.getDuration()));
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

@Data
@NoArgsConstructor
final class Request {
    private String name;
    private String duration;
}

