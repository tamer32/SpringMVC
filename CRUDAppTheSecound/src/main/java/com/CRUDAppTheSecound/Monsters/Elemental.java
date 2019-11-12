package com.CRUDAppTheSecound.Monsters;

import java.util.Map;

public class Elemental extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(15, 12, 18);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Elemental";
  }
}
