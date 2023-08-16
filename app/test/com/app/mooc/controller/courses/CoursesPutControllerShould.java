package com.app.mooc.controller.courses;

import com.app.ApplicationTestCase;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CoursesPutControllerShould extends ApplicationTestCase {

    private Gson gson;
    @BeforeEach
    void setUp(){
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
