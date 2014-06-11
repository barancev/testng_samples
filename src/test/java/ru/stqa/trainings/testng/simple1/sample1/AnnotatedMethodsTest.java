package ru.stqa.trainings.testng.simple1.sample1;

import org.testng.annotations.Test;

public class AnnotatedMethodsTest {

  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
  }

  public void notATest() {
    System.out.println("notATest");
  }

  @Test
  private void privateTest() {
    System.out.println("privateTest");
  }

  @Test(enabled = false)
  public void disabledTest() {
    System.out.println("disabledTest");
  }

}
