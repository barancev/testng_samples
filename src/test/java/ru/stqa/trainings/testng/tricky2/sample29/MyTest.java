package ru.stqa.trainings.testng.tricky2.sample29;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.factory.WebDriverFactory;

public class MyTest {
  
  private WebDriver driver;
  private VideoCreator screencaster;
  private Thread videoThread;
  
  @BeforeClass
  public void startDriver() {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
  }
  
  @BeforeMethod
  public void setUp(Method m) {
    File videoFile = new File(m.getName() + ".flv");
    screencaster = new VideoCreator(videoFile);
    videoThread = new Thread(new Runnable() {
      @Override
      public void run() {
        screencaster.createVideoFromScreens();
      }
    });
    videoThread.start();
  }

  @Test
  public void test1() {
    driver.get("http://www.seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }
  
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    screencaster.setPleaseStop(true);
    while (! screencaster.isStoppedCreation()) {
      Thread.sleep(500);
    }
    videoThread.join();
  }
  

  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverFactory.dismissDriver(driver);
  }
  
}
