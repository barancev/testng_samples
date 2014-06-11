package ru.stqa.trainings.testng.simple1.sample9;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class LoginFixture extends BrowserFixture {

  @BeforeClass
  public void login() {
    System.out.println("Login");
    driver.get("http://localhost/php4dvd");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
  }

  @AfterClass
  public void logout() {
    System.out.println("Logout");
    driver.findElement(By.xpath("//nav/ul/li[4]/a")).click();
  }

}
