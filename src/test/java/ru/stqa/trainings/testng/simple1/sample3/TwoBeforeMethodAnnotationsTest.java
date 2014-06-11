package ru.stqa.trainings.testng.simple1.sample3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TwoBeforeMethodAnnotationsTest {

  @BeforeMethod
  public void setUp1() {
    System.out.println("setUp1");
  }

  @BeforeMethod
  public void setUp2() {
    System.out.println("setUp2");
  }

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

}
