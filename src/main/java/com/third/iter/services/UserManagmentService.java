package com.third.iter.services;

import java.util.LinkedList;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.third.iter.entities.heroes.PlayerInfo;
import com.third.iter.entities.monsters.MonsterInfo;

/** @author p.siderov */
public interface UserManagmentService {

  public void createUser(PlayerInfo player);

  public void checkMonsterEncounter(Integer encounter, Model theModel);

  public void deleteUser(PlayerInfo player);

  public void setPlayerClassAndStats(PlayerInfo player);

  public void modifyName(PlayerInfo player, Model theModel);

  public ResponseEntity<Map<String, String>> battleCalculator();

  public LinkedList<PlayerInfo> listUsers();

  public ResponseEntity<MonsterInfo> checkMonsterEncounter(Integer encounter);

  ResponseEntity<PlayerInfo> login(String username);
}
