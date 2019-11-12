package com.CRUDAppTheSecound.service;

import java.util.LinkedList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.CRUDAppTheSecound.Entities.PlayerInfo;

/** @author p.siderov */
public interface UserManagmentService {

  public void createUser(String username, String playerClass);

  public void checkEncounter(Integer encounter, Model theModel);

  public void deleteUser(PlayerInfo player);

  public void setPlayerClassAndStats(
      Model theModel, @ModelAttribute("playerInfo") PlayerInfo player);

  public void battleCalculator(
      Integer gracefulDice, Integer skullDice, Integer battleScore, Model theModel);

  public LinkedList<PlayerInfo> savedUsers();
}
