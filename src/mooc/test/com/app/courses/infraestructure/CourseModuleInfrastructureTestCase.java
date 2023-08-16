package com.app.courses.infraestructure;

import com.app.infraestructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CourseModuleInfrastructureTestCase extends InfrastructureTestCase {

     @Autowired
     protected InMemoryCourseRepository repository;
}
