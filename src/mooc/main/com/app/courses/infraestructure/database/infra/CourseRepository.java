package com.app.courses.infraestructure.database.infra;

import com.app.courses.infraestructure.database.domain.CourseData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<String, CourseData> {
}
