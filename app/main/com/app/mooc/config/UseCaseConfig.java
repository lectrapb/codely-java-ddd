package com.app.mooc.config;

import com.app.courses.application.created.CourseCreator;
import com.app.courses.domain.CourseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

     @Bean
     public CourseCreator courseCreator(CourseRepository courseRepository){
         return new CourseCreator(courseRepository);
     }
}
