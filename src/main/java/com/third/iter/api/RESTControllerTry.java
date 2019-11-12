package com.third.iter.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RESTControllerTry {
  @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> returnJasonMethod() {
    Map<String, String> map = new HashMap<>();
    Random rand = new Random();
    map.put("key", String.valueOf(rand.nextDouble() * 198327));
    return ResponseEntity.ok(map);
  }
}
