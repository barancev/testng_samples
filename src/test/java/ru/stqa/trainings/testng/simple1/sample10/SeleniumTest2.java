package ru.stqa.trainings.testng.simple1.sample10;

import org.testng.annotations.Test;

@Test
public class SeleniumTest2 extends SeleniumSuiteFixture {

  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
