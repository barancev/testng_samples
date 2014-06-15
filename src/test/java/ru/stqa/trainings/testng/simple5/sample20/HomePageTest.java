package ru.stqa.trainings.testng.simple5.sample20;

import org.testng.annotations.Test;

public class HomePageTest extends SeleniumTestBase {

  @Test
  public void testHomePage() {
    driver.get("http://selenium2.ru/");
  }
}
