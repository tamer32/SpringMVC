package com.CRUDAppTheSecound.Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.CRUDAppTheSecound.Entities.PlayerInfo;
import com.CRUDAppTheSecound.Monsters.MonsterInfo;
import com.CRUDAppTheSecound.service.UserManagmentService;

@Controller
@RequestMapping
@SessionAttributes({"monster", "playerInfo"})
public class UserController {

  @Autowired UserManagmentService userManagmentImp;
  Integer gracefulDice;
  Integer skullDice;
  Integer battleScore;

  @ModelAttribute("playerInfo")
  public PlayerInfo getPlayerInfo() {
    return new PlayerInfo();
  }

  @ModelAttribute("monster")
  public MonsterInfo getMonsterInfo() {
    return new MonsterInfo();
  }

  @PostMapping("/createUser")
  public String createUser(
      Model theModel,
      @ModelAttribute("playerInfo") PlayerInfo player,
      @Valid PlayerInfo playerInfo,
      BindingResult br)
      throws ServletException, IOException {

    if (br.hasErrors()) {
      return "index";
    }
    userManagmentImp.createUser(player.getUsername(), player.getPlayerClass());
    theModel.addAttribute("playerInfo", player);

    return "page";
  }

  @GetMapping("/deletePage")
  protected String deleteUser(@ModelAttribute("playerInfo") PlayerInfo player)
      throws ServletException, IOException {
    userManagmentImp.deleteUser(player);

    return "index";
  }

  @GetMapping("/fightPage")
  public String fightMethod(Model theModel) throws ServletException, IOException {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;
    userManagmentImp.checkEncounter(encounter, theModel);

    return "FightPage";
  }

  @GetMapping("/rollTheDice")
  public String rollingStones(
      Model theModel,
      @ModelAttribute("monster") MonsterInfo monster,
      @ModelAttribute("playerInfo") PlayerInfo player)
      throws IOException, ServletException {

    userManagmentImp.setPlayerClassAndStats(theModel, player);

    // in a nutshell sum of monster stats multiplied by skullDice minus sum of player stats
    // multiplied by graceful dice
    userManagmentImp.battleCalculator(gracefulDice, skullDice, battleScore, theModel);

    return "AfterBattlePage";
  }
}
