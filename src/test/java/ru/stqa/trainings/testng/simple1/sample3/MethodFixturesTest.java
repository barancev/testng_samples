package ru.stqa.trainings.testng.simple1.sample3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class MethodFixturesTest {

  @BeforeMethod
  public void setUp() {
    System.out.println("setUp");
  }

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

  @AfterMethod
  public void tearDown() {
    System.out.println("tearDown");
  }

}
