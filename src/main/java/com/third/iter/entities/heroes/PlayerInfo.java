package com.third.iter.entities.heroes;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonGetter;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerInfo {
  private Long id;

  @NotBlank
  @Size(min = 2, max = 32)
  private String username;

  private static Integer exp;

  @NotNull @NotEmpty String playerClass;
  public static Map<String, Integer> playerAttributes = new HashMap<String, Integer>();

  public Map<String, Integer> getPlayerAttributes() {
    return playerAttributes;
  }

  public void setPlayerAttributes(Map<String, Integer> playerAttributes) {
    PlayerInfo.playerAttributes = playerAttributes;
  }

  @JsonGetter("playerClass")
  public String getPlayerClass() {
    return playerClass;
  }

  @Override
  public String toString() {
    return "PlayerInfo [username=" + username + ", playerClass=" + playerClass + "]";
  }

  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }

  @JsonGetter("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String name) {
    this.username = name;
  }

  public static Integer getExp() {
    return exp;
  }

  @SuppressWarnings("static-access")
  public void setExp(Integer exp) {
    this.exp = exp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
