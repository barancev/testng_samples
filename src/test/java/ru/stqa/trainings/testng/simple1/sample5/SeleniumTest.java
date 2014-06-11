package ru.stqa.trainings.testng.simple1.sample5;

import org.testng.annotations.Test;

@Test
public class SeleniumTest extends SeleniumMethodFixture {

  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
