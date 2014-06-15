package ru.stqa.trainings.testng.simple5.sample20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SeleniumTestBase {
  
  protected WebDriver driver;

  @BeforeClass(alwaysRun = true)
  @Parameters("browser")
  public void startBrowser(String browser) {
    System.out.println("Starting " + browser);
    if (browser.equals("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equals("chrome")) {
      driver = new ChromeDriver();
    } else {
      throw new Error("Unknown browser " + browser);
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopBrowser() {
    System.out.println("Stopping " + driver);
    if (driver != null) {
      driver.quit();
    }
  }

}
