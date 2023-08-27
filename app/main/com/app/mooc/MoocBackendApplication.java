package com.app.mooc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
//@ComponentScan( value = {"com.app", "com.app.mooc"})
public class MoocBackendApplication {


    public static Map<String, Class<?>> commands(){
         return new HashMap<String, Class<?>>(){{

             put("Fake", String.class);
         }};
    }
}
