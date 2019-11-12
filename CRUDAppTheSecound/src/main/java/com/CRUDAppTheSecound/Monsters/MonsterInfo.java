package com.CRUDAppTheSecound.Monsters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MonsterInfo {

  public static Map<String, Integer> monsterAttributes = new HashMap<String, Integer>();

  public Map<String, Integer> getMonsterAttributes() {
    return monsterAttributes;
  }

  public static void setMonsterAttributes(Map<String, Integer> monsterAttributes) {

    MonsterInfo.monsterAttributes = monsterAttributes;
  }

  public static void monsterAttributes(Integer strenght, Integer agility, Integer intelect) {
    monsterAttributes.put("Strenght", strenght);
    monsterAttributes.put("Agility", agility);
    monsterAttributes.put("Intelect", intelect);
  }
}
