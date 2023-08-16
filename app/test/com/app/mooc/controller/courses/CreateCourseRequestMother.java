package com.app.mooc.controller.courses;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CreateCourseRequestMother {


    public static String create(String name, String duration ){

        Gson gson = new Gson();
        Map<String, String> req = new HashMap<>();
        req.put("name", name);
        req.put("duration", duration);
        return gson.toJson(req);
    }

    public  static String  random() {
        Gson gson = new Gson();
        Map<String, String> req = new HashMap<>();
        req.put("name", "The best course");
        req.put("duration", "5 Hours");

        return gson.toJson(req);
    }
}
