package ru.stqa.trainings.testng.simple4.sample17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SeleniumTestBase {
  
  protected WebDriver driver;
  protected SeleniumAssertion check;

  @BeforeSuite(alwaysRun = true)
  public void startBrowser() {
    driver = new FirefoxDriver();
    check = new SeleniumAssertion(driver);
  }
  
  @AfterSuite(alwaysRun = true)
  public void stopBrowser() {
    if (driver != null) {
      driver.quit();
    }
  }

}
