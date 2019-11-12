package com.CRUDAppTheSecound.Entities;

public class Sorcerer extends PlayerInfo {
  public void getStats() {
    super.setStats(4, 4, 22);
  }

  public void getLvl() {
    super.levelUp(4, 3, 13);
  }
}
