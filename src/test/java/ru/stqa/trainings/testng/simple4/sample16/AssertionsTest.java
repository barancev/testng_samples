package ru.stqa.trainings.testng.simple4.sample16;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

  @Test
  public void testAssertKeyword() {
    assert 2 * 2 == 5;
  }

  @Test
  public void testAssertJUnit() {
    AssertJUnit.assertEquals(5, 2 * 2);
  }

  @Test
  public void testAssertTestNG() {
    Assert.assertEquals(2 * 2, 5);
  }

  @Test
  public void testAssertion() {
	Assertion s = new Assertion();
    s.assertEquals(2 * 2, 5);
  }

  @Test
  public void testSoftAssert() {
	  SoftAssert s = new SoftAssert();
    s.assertEquals(2 * 2, 3, "Three");
    s.assertEquals(2 * 2, 5, "Five");
    s.assertAll();
  }
}
