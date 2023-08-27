package com.app.courses.domain;

import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;

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
