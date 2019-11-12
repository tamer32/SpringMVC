package com.CRUDAppTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.third.iter.entities.heroes.PlayerInfo;
import com.third.iter.services.UserManagmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestForDnD {

  @Mock PlayerInfo player;

  @InjectMocks UserManagmentServiceImpl userService;

  @Before
  public void setUp() {
    Mockito.when(player.getUsername()).thenReturn("Pesho");
    Mockito.when(player.getPlayerClass()).thenReturn("Warrior");
  }

  @Test
  public void createUserTest() {

    userService.createUser(player);
    assertThat(userService.listUsers().size(), is(1));
    assertThat(userService.listUsers().getLast().getUsername(), is(player.getUsername()));
  }

  @Test
  public void testIsBetween() {
    int lowerNumber = 2;
    int number = 3;
    int biggerNumber = 4;
    assertTrue(userService.isBetween(number, lowerNumber, biggerNumber));
  }

  public void checkEncounter() {
    userService.checkMonsterEncounter(8);
  }
}
