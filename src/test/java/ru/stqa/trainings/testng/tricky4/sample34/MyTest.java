package ru.stqa.trainings.testng.tricky4.sample34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ru.stqa.selenium.factory.WebDriverFactory;

@Listeners(VideoListener.class)
public class MyTest {

  private WebDriver driver;
  
  @BeforeClass
  public void startDriver() {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
  }
  
  @Test
  public void test1() {
    driver.get("http://www.seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverFactory.dismissDriver(driver);
  }
  
}
