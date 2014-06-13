package ru.stqa.trainings.testng.simple3.sample15;

import org.testng.annotations.Test;

public class SoftDependenciesTest {

  @Test(dependsOnMethods = "test2", alwaysRun = true)
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
	throw new Error();
  }
}
