package com.hibernate.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hibernate.base.Entities.FormData;
import com.hibernate.base.Entities.User;
import com.hibernate.base.service.UserService;

@RestController
@RequestMapping
public class UserApi {
  @Autowired UserService service;

  @PostMapping(
      value = "/createUser",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE,
      headers = "Accept=application/json")
  public ResponseEntity<User> createUser(@RequestBody FormData formData) {
    return service.createUser(
        formData.getUsername(), formData.getAge(), formData.getAddress(), formData.getZipCode());
  }
}
