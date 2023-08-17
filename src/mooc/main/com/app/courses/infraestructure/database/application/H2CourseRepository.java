package com.app.courses.infraestructure.database.application;

import com.app.courses.domain.Course;
import com.app.courses.domain.CourseRepository;
import com.app.courses.infraestructure.database.infra.JPACourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("h2-repository")
@AllArgsConstructor
public class H2CourseRepository implements CourseRepository {

    private final JPACourseRepository repository;
    @Override
    @Transactional
    public void save(Course course) {
        repository.save(Mapper.toEntity(course));
    }

    @Override
    public Optional<Course> search(String id) {
        var result = repository.findById(id)
                .orElseGet(null);
        return Optional.of(Mapper.toModel(result));
    }
}
