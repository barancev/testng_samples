package ru.stqa.trainings.testng.simple4.sample17;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumAssertionsTest extends SeleniumTestBase {

  @Test
  public void testAssertion() {
    SeleniumAssertion check = new SeleniumAssertion(driver);
    driver.get("http://selenium2.ru/");
    check.assertPresentElementLocated(By.id("header1"));
    check.assertDisplayed(driver.findElement(By.id("header")));
  }

}
