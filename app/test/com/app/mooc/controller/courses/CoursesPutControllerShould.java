package com.app.mooc.controller.courses;

import com.app.ApplicationTestCase;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoursesPutControllerShould extends ApplicationTestCase {

    @Test
    void create_a_valid_course() throws Exception{
        var uid = UUID.randomUUID().toString();
        Map<String, String> req = new HashMap<>();
        req.put("name", "The best course");
        req.put("duration", "5 Hours");
        Gson gson = new Gson();

        assertRequestWithBody("PUT",
                "/courses/"+uid,
                gson.toJson(req),
                201);
    }
}
