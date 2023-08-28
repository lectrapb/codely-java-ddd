package com.app.courses.infraestructure.database.infra;

import com.app.courses.infraestructure.database.domain.CourseData;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JPACourseRepository extends JpaRepository<CourseData,String> {
}
