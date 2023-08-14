package com.app.mooc.controller.health_check;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckGetController {

     @GetMapping("/health-check")
     public ResponseEntity<Map<String, String>> handle(){

         Map<String, String> status = new HashMap<>();
         status.put("status", "ok");
         return ResponseEntity.ok(status);

     }
}
