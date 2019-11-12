package com.CRUDAppTheSecound.service;

import java.util.LinkedList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.CRUDAppTheSecound.Entities.Bowman;
import com.CRUDAppTheSecound.Entities.PlayerInfo;
import com.CRUDAppTheSecound.Entities.Rogue;
import com.CRUDAppTheSecound.Entities.Sorcerer;
import com.CRUDAppTheSecound.Entities.Warrior;
import com.CRUDAppTheSecound.Monsters.Bandit;
import com.CRUDAppTheSecound.Monsters.Dragon;
import com.CRUDAppTheSecound.Monsters.Elemental;
import com.CRUDAppTheSecound.Monsters.Goblin;
import com.CRUDAppTheSecound.Monsters.MechaGolem;
import com.CRUDAppTheSecound.Monsters.MonsterInfo;
import com.CRUDAppTheSecound.Monsters.VajirSorceress;
import com.CRUDAppTheSecound.Monsters.Werewolf;
import com.CRUDAppTheSecound.Monsters.Zombie;

@Service
public class UserManagmentImp implements UserManagmentService {

  public static LinkedList<PlayerInfo> users = new LinkedList<PlayerInfo>();
  @Autowired PlayerInfo player;
  @Autowired MonsterInfo monster;

  @Override
  public void createUser(String username, String playerClass) {
    PlayerInfo user = new PlayerInfo();
    user.setUsername(username);
    user.setPlayerClass(playerClass);
    users.add(user);
  }

  @Override
  public void deleteUser(PlayerInfo player) {
    player.getPlayerAttributes().remove("Strenght");
    player.getPlayerAttributes().remove("Agility");
    player.getPlayerAttributes().remove("Intelect");
    users.remove(player);
  }

  @Override
  public LinkedList<PlayerInfo> savedUsers() {
    return users;
  }

  public boolean isBetween(int x, int lower, int upper) {
    return lower <= x && x <= upper;
  }

  @Override
  public void checkEncounter(Integer encounter, Model theModel) {
    if (isBetween(encounter, 1, 10)) {
      theModel.addAttribute("monster", new Goblin());
    } else if (isBetween(encounter, 11, 20)) {
      theModel.addAttribute("monster", new Bandit());
    } else if (isBetween(encounter, 11, 20)) {
      theModel.addAttribute("monster", new Zombie());
    } else if (isBetween(encounter, 21, 27)) {
      theModel.addAttribute("monster", new VajirSorceress());
    } else if (isBetween(encounter, 28, 35)) {
      theModel.addAttribute("monster", new Werewolf());
    } else if (isBetween(encounter, 35, 41)) {
      theModel.addAttribute("monster", new MechaGolem());
    } else if (isBetween(encounter, 42, 46)) {
      theModel.addAttribute("monster", new Elemental());
    } else if (isBetween(encounter, 46, 50)) {
      theModel.addAttribute("monster", new Dragon());
    }
  }

  @Override
  public void setPlayerClassAndStats(
      Model theModel, @ModelAttribute("playerInfo") PlayerInfo player) {
    if (player.getPlayerClass().equals("Warrior")) {
      Warrior war = new Warrior();
      war.getStats();
      theModel.addAttribute("player", war);
    } else if (player.getPlayerClass().equals("Bowman")) {
      Bowman bowman = new Bowman();
      bowman.getStats();
      theModel.addAttribute("player", bowman);
    } else if (player.getPlayerClass().equals("Rogue")) {
      Rogue rogue = new Rogue();
      rogue.getStats();
      theModel.addAttribute("player", rogue);
    } else if (player.getPlayerClass().equals("Sorcerer")) {
      Sorcerer sorcerer = new Sorcerer();
      sorcerer.getStats();
      theModel.addAttribute("player", sorcerer);
    }
  }

  @Override
  public void battleCalculator(
      Integer gracefulDice, Integer skullDice, Integer battleScore, Model theModel) {
    Random rand = new Random();
    gracefulDice = rand.nextInt(5) + 1;
    skullDice = rand.nextInt(5) + 1;
    battleScore =
        ((monster.getMonsterAttributes().get("Strenght")
                    + monster.getMonsterAttributes().get("Agility")
                    + monster.getMonsterAttributes().get("Intelect"))
                * skullDice)
            - ((player.getPlayerAttributes().get("Strenght")
                    + player.getPlayerAttributes().get("Agility")
                    + player.getPlayerAttributes().get("Intelect"))
                * gracefulDice);
    theModel.addAttribute("gracefulDice", gracefulDice);
    theModel.addAttribute("skullDice", skullDice);
    theModel.addAttribute("battleResult", battleScore);
  }
}
