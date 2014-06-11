package ru.stqa.trainings.testng.simple1.sample1;

import org.testng.annotations.Test;

public class ChildOfAnnotatedMethodsTest extends AnnotatedMethodsTest {

  @Test
  public void childTest() {
    System.out.println("childTest");
  }

}
