package com.third.iter.controlers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.third.iter.entities.heroes.PlayerInfo;
import com.third.iter.entities.monsters.MonsterInfo;
import com.third.iter.services.UserManagmentService;

@Controller
@SessionAttributes({"monster", "playerInfo"})
public class UserController {

  @Autowired UserManagmentService userManagmentService;
  Integer playerExp;

  @ModelAttribute("playerInfo")
  public PlayerInfo getPlayerInfo() {
    return new PlayerInfo();
  }

  @ModelAttribute("monster")
  public MonsterInfo getMonsterInfo() {
    return new MonsterInfo();
  }

  @RequestMapping("/")
  public String homePage(Model springModel) {
    springModel.addAttribute(new PlayerInfo());
    return "HomePage";
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

    userManagmentService.createUser(player);
    theModel.addAttribute("playerInfo", player);

    return "redirect:/userInfo";
  }

  @GetMapping("/loginPage")
  public String redirectToLogin() {

    return "LoginPage";
  }

  @GetMapping("/registerPage")
  public String redirectToRegister() {
    return "index";
  }

  @GetMapping("/userInfo")
  public String userPanel(Model theModel, @ModelAttribute("playerInfo") PlayerInfo player) {
    theModel.addAttribute("playerInfo", player);
    return "CharacterPage";
  }

  @GetMapping("/deletePage")
  protected String deleteUser(@ModelAttribute("playerInfo") PlayerInfo player)
      throws ServletException, IOException {
    userManagmentService.deleteUser(player);
    return "index";
  }

  @GetMapping("/fightPage")
  public String fightMethod(Model theModel) throws ServletException, IOException {
    Random rand = new Random();
    int encounter = rand.nextInt(49) + 1;

    userManagmentService.checkMonsterEncounter(encounter, theModel);

    return "FightPage";
  }

  @GetMapping("/modifyPage")
  public String goToModifyPage() {

    return "ModifyPage";
  }

  @PostMapping("/modifyPage")
  public String modifyName(@ModelAttribute("playerInfo") PlayerInfo player, Model theModel) {
    userManagmentService.modifyName(player, theModel);

    return "CharacterPage";
  }

  @GetMapping("/tryingDataBinding")
  public String dataBinding(@RequestParam int number) {

    System.out.println(number);

    return "AfterBattlePage";
  }
}
