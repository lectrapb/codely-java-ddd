package com.app.courses_counter.infraestructure.database.infra;

import com.app.courses_counter.infraestructure.database.domain.CoursesCounterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACourseCounterRepository extends JpaRepository<CoursesCounterData, String> {
}
