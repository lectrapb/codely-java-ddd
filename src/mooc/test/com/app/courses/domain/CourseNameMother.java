package com.app.courses.domain;

import com.app.courses.domain.value.CourseName;
import com.app.domain.WordMother;

public class CourseNameMother {

    public static CourseName create(String value){
        return new CourseName(value);
    }

    public static CourseName random(){
        return create(WordMother.random());
    }
}
