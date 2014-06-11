package ru.stqa.trainings.testng.simple1.sample6;

import org.testng.annotations.*;

@Test
public class ClassFixtureTest {

  @BeforeClass
  public void setUp() {
    System.out.println("setUp");
  }

  public void test1() {
    System.out.println("test1");
  }

  public void test2() {
    System.out.println("test2");
  }

  @AfterClass
  public void tearDown() {
    System.out.println("tearDown");
  }

}
