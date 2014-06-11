package ru.stqa.trainings.testng.simple1.sample2;

import org.testng.annotations.Test;

@Test
public class AnnotatedClassTest {

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

  private void notATest() {
    System.out.println("notATest");
  }

  @Test(enabled = false)
  public void disabledTest() {
    System.out.println("disabledTest");
  }

}
