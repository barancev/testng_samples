package ru.stqa.trainings.testng.simple1.sample4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Test1 extends TestBase {

  @BeforeMethod
  public void setUp() {
    System.out.println("setUp");
  }

  @AfterMethod
  public void tearDown() {
    System.out.println("tearDown");
  }

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

}
