package ru.stqa.trainings.testng.simple1.sample10;

import org.testng.annotations.Test;

@Test
public class SeleniumTest1 extends SeleniumSuiteFixture {

  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

}
