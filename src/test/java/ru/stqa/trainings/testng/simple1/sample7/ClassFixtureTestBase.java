package ru.stqa.trainings.testng.simple1.sample7;

import org.testng.annotations.*;

@Test
public class ClassFixtureTestBase {

  @BeforeClass
  public void setUp() {
    System.out.println("setUp");
  }

  @AfterClass
  public void tearDown() {
    System.out.println("tearDown");
  }

}
