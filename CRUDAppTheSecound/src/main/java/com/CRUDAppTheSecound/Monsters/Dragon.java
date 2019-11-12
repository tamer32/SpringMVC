package com.CRUDAppTheSecound.Monsters;

import java.util.Map;

public class Dragon extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(35, 35, 45);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Dragon (You are probably fucked up...)";
  }
}
