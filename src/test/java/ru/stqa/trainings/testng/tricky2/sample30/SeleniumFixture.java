package ru.stqa.trainings.testng.tricky2.sample30;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.stqa.selenium.factory.WebDriverFactory;

public class SeleniumFixture {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
  }
  
  @BeforeMethod
  public void refreshDriver(Method m) {
    System.out.println("Before method " + m.getName());
    if (m.getAnnotation(NeedsFreshDriver.class) != null) {
      System.out.println("Restarting the browser");
      WebDriverFactory.dismissDriver(driver);
      driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverFactory.dismissDriver(driver);
  }
  
}
