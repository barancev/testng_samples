package ru.stqa.trainings.testng.simple1.sample10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class SeleniumSuiteFixture {

  static protected WebDriver driver;

  @BeforeSuite
  public void setUp() {
    System.out.println("Starting a browser");
    driver = new FirefoxDriver();
  }

  @AfterSuite
  public void tearDown() {
    System.out.println("Stopping the browser");
    if (driver != null) {
      driver.quit();
    }
  }

}
