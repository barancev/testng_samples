package ru.stqa.trainings.testng.tricky2.sample28;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.factory.WebDriverFactory;

public class MyTest {
  
  private WebDriver driver;
  
  @BeforeClass
  public void startDriver() {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
  }
  
  @BeforeMethod
  public void setUp() {
    driver.manage().logs().get("browser"); // clean logs out
  }

  @Test
  public void test1() {
    driver.get("http://www.seleniumhq.org/");
  }

  @Test
  public void test2() {
    driver.get("http://selenium2.ru/");
  }
  
  @AfterMethod
  public void tearDown(Method m) throws IOException {
    LogEntries logEntries = driver.manage().logs().get("browser");
    File driverLog = new File(m.getName() + ".log");
    FileWriter out = new FileWriter(driverLog);
    for (LogEntry logEntry : logEntries.getAll()) {
      out.write(logEntry.toString() + "\n");
    }
    out.close();
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverFactory.dismissDriver(driver);
  }
}
