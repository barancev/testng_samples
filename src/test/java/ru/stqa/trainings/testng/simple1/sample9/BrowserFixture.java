package ru.stqa.trainings.testng.simple1.sample9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class BrowserFixture {

  protected WebDriver driver;

  @BeforeClass
  public void setUp() {
    System.out.println("Starting a browser");
    driver = new FirefoxDriver();
  }

  @AfterClass
  public void tearDown() {
    System.out.println("Stopping the browser");
    if (driver != null) {
      driver.quit();
    }
  }

}
