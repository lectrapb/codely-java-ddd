package com.app.mooc.controller.courses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesPutController {

    @PutMapping("/courses/{id}")
    public ResponseEntity created(@PathVariable String id,
                                  @RequestBody  Request request ){

       return new ResponseEntity(HttpStatus.CREATED);
    }

}
@Data
@NoArgsConstructor
final class Request{
    private String name;
    private String duration;
}

