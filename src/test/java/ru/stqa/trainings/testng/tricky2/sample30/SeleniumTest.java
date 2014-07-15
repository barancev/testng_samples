package ru.stqa.trainings.testng.tricky2.sample30;

import org.testng.annotations.Test;

public class SeleniumTest extends SeleniumFixture {

  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  @NeedsFreshDriver
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
