package com.app.courses.application.created;

import com.app.courses.domain.value.CourseDuration;
import com.app.courses.domain.value.CourseId;
import com.app.courses.domain.value.CourseName;
import com.app.domain.bus.command.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {

    private final CourseCreator creator;

    public CreateCourseCommandHandler(CourseCreator courseCreator) {
        this.creator = courseCreator;
    }

    @Override
    public void handle(CreateCourseCommand command) {

        CourseId id = new CourseId(command.id());
        CourseName name = new CourseName(command.name());
        CourseDuration duration = new CourseDuration(command.duration());

        creator.create(id, name, duration);
    }
}
