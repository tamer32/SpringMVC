package com.third.iter.entities.monsters;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MonsterInfo {

  public static Map<String, Integer> monsterAttributes = new HashMap<String, Integer>();

  public Map<String, Integer> getMonsterAttributes() {
    return monsterAttributes;
  }

  public static void monsterAttributes(Integer strenght, Integer agility, Integer intelect) {
    monsterAttributes.put("Strenght", strenght);
    monsterAttributes.put("Agility", agility);
    monsterAttributes.put("Intelect", intelect);
  }
}
