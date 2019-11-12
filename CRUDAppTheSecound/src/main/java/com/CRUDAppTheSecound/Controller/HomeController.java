package com.CRUDAppTheSecound.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUDAppTheSecound.Entities.PlayerInfo;
import com.CRUDAppTheSecound.Monsters.MonsterInfo;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String homePage(Model springModel) {
    springModel.addAttribute(new PlayerInfo());
    return "index";
  }
}
