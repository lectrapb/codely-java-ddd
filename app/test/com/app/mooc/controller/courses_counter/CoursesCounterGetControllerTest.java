package com.app.mooc.controller.courses_counter;

import com.app.ApplicationTestCase;
import com.app.courses.domain.events.CourseCreatedDomainEvent;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoursesCounterGetControllerTest  extends ApplicationTestCase {

    private Gson gson;
    @BeforeEach
    void setUp() {
        gson = new Gson();
    }

    @Test
    void get_the_counter_with_one_course() throws Exception {
        givenISendEventsToTheBus(
                new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java", "7 days")
        );


        assertResponse("/courses-counter", 200, "{'total': 1}");
    }




}