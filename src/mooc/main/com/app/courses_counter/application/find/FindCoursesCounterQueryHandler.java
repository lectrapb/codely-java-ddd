package com.app.courses_counter.application.find;

import com.app.domain.bus.query.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindCoursesCounterQueryHandler implements QueryHandler<FindCoursesCounterQuery, CoursesCounterResponse> {

    private final CoursesCounterFinder finder;
    @Override
    public CoursesCounterResponse handle(FindCoursesCounterQuery query) {
        return finder.find();
    }
}
