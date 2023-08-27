package com.app.courses.infraestructure.database.application;

import com.app.courses.domain.Course;
import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.courses.infraestructure.database.domain.CourseData;

public class Mapper {

    public static Course toModel(CourseData courseData){

        return new Course(new CourseId(courseData.getId()),
                new CourseName(courseData.getName()),
                new CourseDuration(courseData.getDuration()));
    }

    public static CourseData toEntity(Course course){

        return course != null ? CourseData.builder()
                .id(course.id().value())
                .name(course.name().value())
                .duration(course.duration().value())
                .build()
                : null;
    }
}
