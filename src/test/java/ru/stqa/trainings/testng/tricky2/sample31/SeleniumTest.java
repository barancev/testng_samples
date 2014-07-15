package ru.stqa.trainings.testng.tricky2.sample31;

import static ru.stqa.trainings.testng.tricky2.sample31.IgnoreInBrowser.Browser.*;

import org.testng.annotations.Test;

public class SeleniumTest extends SeleniumFixture {

  @Test
  public void test1() {
    driver.get("http://seleniumhq.org/");
  }

  @Test
  @IgnoreInBrowser(CHROME)
  public void test2() {
    driver.get("http://selenium2.ru/");
  }

}
