package ru.stqa.trainings.testng.simple2.sample13;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupFixturesTest {

  @BeforeGroups(groups = {"G13_1"})
  public void setUpG1() {
    System.out.println("setUpG13_1");
  }

  @BeforeMethod(groups = {"G13_1"})
  public void setUp() {
    System.out.println("setUp");
  }

  @Test(groups = {"G13_1"})
  public void test1() {
    System.out.println("test1");
  }

  @Test(groups = {"G13_2"})
  public void test2() {
    System.out.println("test2");
  }

  @AfterGroups(groups = {"G13_1"})
  public void tearDownG1() {
    System.out.println("tearDownG3_1");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    System.out.println("tearDown");
  }

}
