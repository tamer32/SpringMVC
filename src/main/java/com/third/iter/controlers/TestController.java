package com.third.iter.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class TestController {
  @GetMapping("/test")
  public void pathVariableTest(@RequestParam() String id) {
    Integer idNumber = Integer.parseInt(id);
    if (idNumber == 1) {
      System.out.println("Success for Id=1");
    } else {
      System.out.println("Id != 1");
    }
  }

  @GetMapping("/testBegin")
  public String testStart() {
    return "testPage";
  }

  @GetMapping("/modelAnnotationTest")
  @ModelAttribute("testAttribute")
  public void testAnnotation(@RequestParam String anotherNumber, Model theModel) {}
}
