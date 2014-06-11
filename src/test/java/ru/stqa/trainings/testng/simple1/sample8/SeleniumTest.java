package ru.stqa.trainings.testng.simple1.sample8;

import org.testng.annotations.Test;

import ru.stqa.trainings.testng.simple1.sample5.SeleniumMethodFixture;

@Test
public class SeleniumTest extends SeleniumClassFixture {

  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
