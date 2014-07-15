package ru.stqa.trainings.testng.tricky2.sample31;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.trainings.testng.tricky2.sample31.IgnoreInBrowser.Browser;

public class SeleniumFixture {

  protected WebDriver driver;

  @BeforeClass
  public void startDriver() {
    driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
  }
  
  @BeforeMethod
  public void ignoreInBrowser(Method m) {
    IgnoreInBrowser ignore = m.getAnnotation(IgnoreInBrowser.class);
    if (ignore != null) {
      String browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
      Browser[] ignoredBrowsers = ignore.value();
      for (Browser ignoredBrowser : ignoredBrowsers) {
        if (ignoredBrowser.name().toLowerCase().equals(browser)) {
          throw new SkipException("Ignored in browser " + browser);
        }
      }
    }
  }
  
  @AfterClass(alwaysRun = true)
  public void stopDriver() {
    WebDriverFactory.dismissDriver(driver);
  }
  
}
