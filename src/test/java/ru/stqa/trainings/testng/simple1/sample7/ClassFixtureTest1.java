package ru.stqa.trainings.testng.simple1.sample7;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class ClassFixtureTest1 extends ClassFixtureTestBase {

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

}
