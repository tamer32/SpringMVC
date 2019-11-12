package com.third.iter.entities.heroes;

public class Bowman extends PlayerInfo {
  public void getStats() {
    super.setStats(8, 15, 7);
  }

  public void getLvl() {
    super.levelUp(4, 7, 4);
  }
}
