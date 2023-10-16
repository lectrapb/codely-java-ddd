package com.app.mooc.controller.courses;

import com.app.ApplicationTestCase;
import com.app.courses.application.created.CourseCreator;
import com.app.courses.application.created.CreateCourseCommandHandler;
import com.app.courses.domain.gateway.CourseRepository;
import com.app.domain.bus.event.EventBus;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CoursesPutControllerHandlerShould extends ApplicationTestCase {

    CreateCourseCommandHandler handler;
    private  CourseRepository repository;
    private   EventBus eventBus;
    private Gson gson;
    @BeforeEach
    void setUp(){
        handler = new CreateCourseCommandHandler(new CourseCreator(repository, eventBus));
        gson = new Gson();
    }

    @Test
    void create_a_valid_course() throws Exception{

        assertRequestWithBody("PUT",
                "/courses/"+UUID.randomUUID().toString(),
                 CreateCourseRequestMother.random(),
                201);
    }


}
