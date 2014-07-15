package ru.stqa.trainings.testng.tricky2.sample27;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MyTest {
  
  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
    Assert.assertTrue(false);
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) {
    if (! result.isSuccess()) {
      System.out.println("Taking screenshot after failure of " + result.getName());
    }
  }
}
