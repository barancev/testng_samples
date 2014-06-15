package ru.stqa.trainings.testng.simple5.sample19;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest extends SeleniumTestBase {

  @Test
  @Parameters({"username", "password"})
  public void testLogin(String user, String password) {
    driver.get("http://localhost/php4dvd/");
    driver.findElement(By.name("username")).sendKeys(user);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("submit")).click();
  }
  
  @AfterMethod
  public void logout() {
    driver.findElement(By.linkText("Log out")).click();
    driver.switchTo().alert().accept();
  }
}
