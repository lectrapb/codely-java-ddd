package com.app.courses.domain;

import com.github.javafaker.Faker;

import java.util.UUID;

public class CourseMother {

    public static Course create (CourseId id , CourseName name, CourseDuration duration){
        return new Course(id, name, duration);
    }

    public static Course random(){
        return new Course(new CourseId(UUID.randomUUID().toString()),
                CourseNameMother.random(),
                new CourseDuration("some-duration"));
    }
}
