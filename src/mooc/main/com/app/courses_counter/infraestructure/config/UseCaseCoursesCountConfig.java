package com.app.courses_counter.infraestructure.config;

import com.app.courses_counter.application.find.CoursesCounterFinder;
import com.app.courses_counter.application.increment.CoursesCounterIncrementer;
import com.app.courses_counter.application.increment.IncrementCoursesCounterOnCourseCreated;
import com.app.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import com.app.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseCoursesCountConfig {


    @Bean
    public CoursesCounterFinder coursesCounterFinder(CoursesCounterSearchRepository searchRepository){
        return new CoursesCounterFinder(searchRepository);
    }

    @Bean
    public CoursesCounterIncrementer coursesCounterIncrementer(CoursesCounterSaveRepository saveRepository,
                                                               CoursesCounterSearchRepository searchRepository ){
        return new CoursesCounterIncrementer(saveRepository, searchRepository);
    }


    @Bean
    public IncrementCoursesCounterOnCourseCreated incrementCoursesCounterOnCourseCreated(CoursesCounterIncrementer incrementer){
        return  new IncrementCoursesCounterOnCourseCreated(incrementer);
    }
}
