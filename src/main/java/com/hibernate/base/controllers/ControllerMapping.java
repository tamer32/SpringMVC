package com.hibernate.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hibernate.base.service.UserService;

@Controller
public class ControllerMapping {
  @Autowired UserService service;

  @RequestMapping("/")
  public String homePage() {
    return "index";
  }

  @GetMapping("/UserPage")
  public String viewUsersRedirect(Model theModel) {

    theModel.addAttribute("users", service.getUsers());
    return "UserPage";
  }

  @PostMapping(value = "/deleteUser")
  public String deleteUser(@RequestParam("id") Integer userId) {
    service.deleteUser(userId);
    return "UserPage";
  }
}
