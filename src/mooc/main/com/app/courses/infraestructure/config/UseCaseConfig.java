package com.app.courses.infraestructure.config;

import com.app.courses.application.created.CourseCreator;
import com.app.courses.application.created.CreateCourseCommandHandler;
import com.app.courses.domain.gateway.CourseRepository;
import com.app.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {



    @Bean
    public CourseCreator courseCreator(EventBus eventBus,
                                       @Qualifier("h2-repository")CourseRepository repository ){
        return new CourseCreator(repository, eventBus);
    }




}
