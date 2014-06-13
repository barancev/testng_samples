package ru.stqa.trainings.testng.simple2.sample11;

import org.testng.annotations.Test;

public class TaggedMethodsTest {

  @Test(groups = "positive")
  public void test1() {
    System.out.println("positive test");
  }

  @Test(groups = {"positive", "broken"})
  public void test2() {
    System.out.println("positeve broken test");
  }

  @Test(groups = "negative")
  public void test3() {
    System.out.println("negative test");
  }

}
