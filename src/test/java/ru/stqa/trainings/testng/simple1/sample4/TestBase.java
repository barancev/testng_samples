package ru.stqa.trainings.testng.simple1.sample4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestBase {

  @BeforeMethod
  public void baseSetUp() {
    System.out.println("baseSetUp");
  }

  @AfterMethod
  public void baseTearDown() {
    System.out.println("baseTearDown");
  }

}
