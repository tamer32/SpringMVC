package com.third.iter.controlers;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.third.iter.entities.heroes.PlayerInfo;
import com.third.iter.entities.monsters.MonsterInfo;
import com.third.iter.services.UserManagmentService;

@RestController
@RequestMapping
public class RestControl {
  @Autowired UserManagmentService userManagmentService;

  @GetMapping(value = "/rollTheDice", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> rollingStones() throws IOException, ServletException {
    return userManagmentService.battleCalculator();
  }

  @GetMapping(value = "/newEncounter", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MonsterInfo> checkEncounter(Model model) {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;
    model.addAttribute("hymjyj", "jtjtyjt");
    return userManagmentService.checkMonsterEncounter(encounter);
  }

  @PostMapping(value = "/loginUser", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerInfo> login(@RequestParam String username) {

    return userManagmentService.login(username);
  }
}
