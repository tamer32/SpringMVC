package com.CRUDAppTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1Test {
  private WebDriver driver;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\p.siderov\\devTools\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    new HashMap<String, Object>();
    new HashMap<String, Integer>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testCase1() throws InterruptedException {

    driver.get("http://localhost:8080/CRUDAppTheSecound/");
    driver.manage().window().setSize(new Dimension(945, 744));
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.cssSelector("body")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("Username");
    driver.findElement(By.id("playerClass4")).click();
    driver.findElement(By.cssSelector("input:nth-child(8)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("Username"));
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("Sorcerer"));
    driver.findElement(By.cssSelector("input")).click();
    driver.findElement(By.cssSelector("input")).click();
    if (driver
        .findElement(By.cssSelector("p"))
        .getText()
        .contains("This time the fate wasn't on your")) {
      testCase1();
    }
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value=\'Fight again!\']")).click();
    driver.findElement(By.cssSelector("input")).click();
    if (driver
        .findElement(By.cssSelector("p"))
        .getText()
        .contains("This time the fate wasn't on your")) {
      testCase1();
    }
    Thread.sleep(5000);
    driver.findElement(By.id("fleeButton")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("Username"));
    assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("Sorcerer"));
  }
}
