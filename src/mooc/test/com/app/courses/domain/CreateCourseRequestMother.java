package com.app.courses.domain;

import com.app.domain.WordMother;

import java.util.UUID;

public class CreateCourseRequestMother {


    public static CreateCourseRequest create(String id, String name, String duration){

         return new CreateCourseRequest(id, name, duration);
    }

    public static CreateCourseRequest random(){

        return new CreateCourseRequest(UUID.randomUUID().toString(), WordMother.random(),
                WordMother.random());
    }
}
