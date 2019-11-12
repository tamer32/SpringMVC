package com.third.iter.entities.heroes;

public class Warrior extends PlayerInfo {
  public void getStats() {
    super.setStats(20, 7, 3);
  }

  public void getLvl() {
    super.levelUp(12, 3, 1);
  }
}
