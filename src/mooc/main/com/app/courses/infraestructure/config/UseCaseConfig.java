package com.app.courses.infraestructure.config;

import com.app.courses.application.created.CourseCreator;
import com.app.courses.domain.gateway.CourseRepository;
import com.app.courses.infraestructure.InMemoryCourseRepository;
import com.app.domain.bus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public CourseCreator courseCreator(EventBus eventBus){
        CourseRepository repository = new InMemoryCourseRepository();
        return new CourseCreator(repository, eventBus);
    }


}
