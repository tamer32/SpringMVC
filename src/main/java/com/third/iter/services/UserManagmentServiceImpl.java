package com.third.iter.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.third.iter.entities.heroes.Bowman;
import com.third.iter.entities.heroes.PlayerInfo;
import com.third.iter.entities.heroes.Rogue;
import com.third.iter.entities.heroes.Sorcerer;
import com.third.iter.entities.heroes.Warrior;
import com.third.iter.entities.monsters.Bandit;
import com.third.iter.entities.monsters.Dragon;
import com.third.iter.entities.monsters.Elemental;
import com.third.iter.entities.monsters.Goblin;
import com.third.iter.entities.monsters.MechaGolem;
import com.third.iter.entities.monsters.MonsterInfo;
import com.third.iter.entities.monsters.VajirSorceress;
import com.third.iter.entities.monsters.Werewolf;
import com.third.iter.entities.monsters.Zombie;

@Service
public class UserManagmentServiceImpl implements UserManagmentService {

  public static LinkedList<PlayerInfo> users = new LinkedList<PlayerInfo>();
  @Autowired PlayerInfo player;
  @Autowired MonsterInfo monster;

  @Override
  public void createUser(PlayerInfo player) {
    player.setExp(0);
    player.setId(Calendar.getInstance().getTimeInMillis());
    users.add(player);
    setPlayerClassAndStats(player);
  }

  @Override
  public void deleteUser(PlayerInfo player) {
    users.remove(player);
  }

  @Override
  public LinkedList<PlayerInfo> listUsers() {
    return users;
  }

  public boolean isBetween(int x, int lower, int upper) {
    return lower <= x && x <= upper;
  }

  @Override
  public void checkMonsterEncounter(Integer encounter, Model theModel) {
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
    } else if (isBetween(encounter, 47, 50)) {
      theModel.addAttribute("monster", new Dragon());
    }
  }

  @Override
  public ResponseEntity<MonsterInfo> checkMonsterEncounter(Integer encounter) {
    if (isBetween(encounter, 1, 10)) {
      return ResponseEntity.ok(new Goblin());
    } else if (isBetween(encounter, 11, 20)) {
      return ResponseEntity.ok(new Bandit());
    } else if (isBetween(encounter, 11, 20)) {
      return ResponseEntity.ok(new Zombie());
    } else if (isBetween(encounter, 21, 27)) {
      return ResponseEntity.ok(new VajirSorceress());
    } else if (isBetween(encounter, 28, 35)) {
      return ResponseEntity.ok(new Werewolf());
    } else if (isBetween(encounter, 35, 41)) {
      return ResponseEntity.ok(new MechaGolem());
    } else if (isBetween(encounter, 42, 46)) {
      return ResponseEntity.ok(new Elemental());
    } else if (isBetween(encounter, 47, 50)) {
      return ResponseEntity.ok(new Dragon());
    }
    return null;
  }

  @Override
  public ResponseEntity<PlayerInfo> login(String username) {
    for (int i = 0; i < listUsers().size(); i++) {
      if (listUsers().get(i).getUsername().equals(username)) {
        return ResponseEntity.ok(listUsers().get(i));
      }
    }
    return null;
  }

  @Override
  public void setPlayerClassAndStats(PlayerInfo player) {
    if (player.getPlayerClass().equals("Warrior")) {
      Warrior war = new Warrior();
      war.getStats();
    } else if (player.getPlayerClass().equals("Bowman")) {
      Bowman bowman = new Bowman();
      bowman.getStats();
    } else if (player.getPlayerClass().equals("Rogue")) {
      Rogue rogue = new Rogue();
      rogue.getStats();
    } else if (player.getPlayerClass().equals("Sorcerer")) {
      Sorcerer sorcerer = new Sorcerer();
      sorcerer.getStats();
    }
  }

  @SuppressWarnings("static-access")
  @Override
  public ResponseEntity<Map<String, String>> battleCalculator() {
    Random rand = new Random();
    Integer gracefulDice = rand.nextInt(5) + 1;
    Integer skullDice = rand.nextInt(5) + 1;
    String message = "";
    Map<String, String> map = new HashMap<>();

    Integer battleScore =
        ((monster.getMonsterAttributes().get("Strenght")
                    + monster.getMonsterAttributes().get("Agility")
                    + monster.getMonsterAttributes().get("Intelect"))
                * skullDice)
            - ((player.getPlayerAttributes().get("Strenght")
                    + player.getPlayerAttributes().get("Agility")
                    + player.getPlayerAttributes().get("Intelect"))
                * gracefulDice);

    map.put("gracefulDice", gracefulDice.toString());
    map.put("skullDice", skullDice.toString());

    if (battleScore < 0) {
      message = "Congratulations on your victory";
      player.setExp(player.getExp() + 1);
      System.out.println(player.getExp());
      map.put("playerExp", player.getExp().toString());
    } else if (battleScore == 0) {
      message =
          "You almost defeat the vile beast, but with it's last drop of luck managed to escape!";
    } else if (battleScore > 0) {
      message =
          "This time the fate wasn't on your side and you lost to the beast and your hero died miserably.Create a new "
              + "character and go avenge your fallen hero!";
    }

    map.put("message", message);
    return ResponseEntity.ok(map);
  }

  @Override
  public void modifyName(PlayerInfo player, Model theModel) {
    users.set(0, player);
    theModel.addAttribute("playerInfo", player);
  }
}
