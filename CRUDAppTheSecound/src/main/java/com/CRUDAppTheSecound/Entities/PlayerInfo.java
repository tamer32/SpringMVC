package com.CRUDAppTheSecound.Entities;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class PlayerInfo {
  @NotBlank
  @Size(min = 2, max = 32)
  String username;

  @NotNull @NotEmpty String playerClass;
  Integer playerLvl = 1;
  public static Map<String, Integer> playerAttributes = new HashMap<String, Integer>();

  public Integer getPlayerLvl() {
    return playerLvl;
  }

  public void setPlayerLvl(Integer playerLvl) {
    this.playerLvl = playerLvl;
  }

  public Map<String, Integer> getPlayerAttributes() {
    return playerAttributes;
  }

  public void setPlayerAttributes(Map<String, Integer> playerAttributes) {
    PlayerInfo.playerAttributes = playerAttributes;
  }

  public String getPlayerClass() {
    return playerClass;
  }

  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String name) {
    this.username = name;
  }

  public static void setStats(Integer strenght, Integer agility, Integer intelect) {
    playerAttributes.put("Strenght", strenght);
    playerAttributes.put("Agility", agility);
    playerAttributes.put("Intelect", intelect);
  }

  public static void levelUp(Integer bonusStrenght, Integer bonusAgility, Integer bonusIntelect) {
    playerAttributes.replace("Strenght", playerAttributes.get("Strenght") + bonusStrenght);
    playerAttributes.replace("Agility", playerAttributes.get("Strenght") + bonusAgility);
    playerAttributes.replace("Intelect", playerAttributes.get("Strenght") + bonusIntelect);
  }
}
