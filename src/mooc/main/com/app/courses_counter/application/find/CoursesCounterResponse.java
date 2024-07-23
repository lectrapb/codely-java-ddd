package com.app.courses_counter.application.find;

import com.app.domain.bus.query.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoursesCounterResponse implements Response {

    private Long total;


}
