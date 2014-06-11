package ru.stqa.trainings.testng.simple1.sample9;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Test
public class SeleniumTest extends LoginFixture {

  public void test1() {
    System.out.println(driver.findElements(By.cssSelector("div.movie_box")).size());
  }

}
