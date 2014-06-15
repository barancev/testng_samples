package ru.stqa.trainings.testng.simple5.sample20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SeleniumTestBase {
  
  protected static WebDriver driver;

  @BeforeTest(alwaysRun = true)
  @Parameters("browser")
  public void startBrowser(String browser) {
    if (browser.equals("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equals("chrome")) {
      driver = new ChromeDriver();
    } else {
      throw new Error("Unknown browser " + browser);
    }
  }
  
  @AfterTest(alwaysRun = true)
  public void stopBrowser() {
    if (driver != null) {
      driver.quit();
    }
  }

}
