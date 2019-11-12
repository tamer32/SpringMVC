package com.CRUDAppTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FightPage {
  @FindBy(how = How.XPATH, using = "//*[@id=\"battleOutcome\"]")
  private WebElement checkText;

  @FindBy(how = How.XPATH, using = "//*[@id=\"showCharacter\"]")
  private WebElement characterScreenButton;

  @FindBy(how = How.XPATH, using = "//*[@id=\"fightAgain\"]")
  private WebElement fightButton;

  @FindBy(xpath = "//*[@id=\"createNewCharacter\"]")
  private WebElement legacyButton;

  public void checkText() {
    if (checkText.getText().contains("Victory")) {
      assertTrue(characterScreenButton.isDisplayed());
      assertTrue(fightButton.isDisplayed());
      assertFalse(legacyButton.isDisplayed());
    } else if (checkText.getText().contains("Create a new character")) {
      assertTrue(legacyButton.isDisplayed());
      assertFalse(characterScreenButton.isDisplayed());
      assertFalse(fightButton.isDisplayed());
    }
  }
}
