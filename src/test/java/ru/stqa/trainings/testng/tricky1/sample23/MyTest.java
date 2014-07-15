package ru.stqa.trainings.testng.tricky1.sample23;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTest {
  
  @BeforeClass
  public void setUp() {
    System.out.println("setUp");
  }

  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
    System.out.println("test2");
  }
  
  @AfterClass
  public void tearDown() {
    System.out.println("tearDown");
  }
}
