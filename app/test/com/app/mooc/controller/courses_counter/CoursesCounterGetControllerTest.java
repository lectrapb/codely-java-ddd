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

    @Test
    void get_the_counter_with_more_than_one_course_having_duplicated_events() throws Exception {
        givenISendEventsToTheBus(
                new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java", "7 days"),
                new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java", "7 days"),
                new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java", "7 days"),
                new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP", "6 days"),
                new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP", "6 days"),
                new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP", "6 days"),
                new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP", "6 days"),
                new CourseCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol", "10 years"),
                new CourseCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol", "10 years")
        );

        assertResponse("/courses-counter", 200, "{'total': 3}");
    }




}