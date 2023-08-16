package com.app.courses.infraestructure.database.application;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseDuration;
import com.app.courses.domain.CourseId;
import com.app.courses.domain.CourseName;
import com.app.courses.infraestructure.database.domain.CourseData;

public class Mapper {

    public Course toModel(CourseData courseData){

        return new Course(new CourseId(courseData.getId()),
                new CourseName(courseData.getName()),
                new CourseDuration(courseData.getDuration()));
    }
}
