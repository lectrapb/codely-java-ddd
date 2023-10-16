package com.app.courses.domain;

import com.app.courses.application.created.CreateCourseCommand;
import com.app.domain.WordMother;

import java.util.UUID;

public class CreateCourseRequestMother {


    public static CreateCourseCommand create(String id, String name, String duration){

         return new CreateCourseCommand(id, name, duration);
    }

    public static CreateCourseCommand random(){

        return new CreateCourseCommand(UUID.randomUUID().toString(), WordMother.random(),
                WordMother.random());
    }
}
