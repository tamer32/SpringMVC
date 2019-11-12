package com.third.iter.entities.heroes;

public class Rogue extends PlayerInfo {
  public void getStats() {
    super.setStats(11, 15, 4);
  }

  public void getLvl() {
    super.levelUp(6, 7, 2);
  }
}
