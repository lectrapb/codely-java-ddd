package com.app.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class JsonSerializer {

    private static Gson gson = new Gson();
    private JsonSerializer() {
    }

    public static String jsonEncode(HashMap<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }


    public static Map<String, Serializable> jsonDecode(String body) {

        try{
            return (body != null) ? gson.fromJson(body, HashMap.class): new HashMap<>();
        }catch (JsonSyntaxException ex){
            return  new HashMap<>();
        }
    }
}
