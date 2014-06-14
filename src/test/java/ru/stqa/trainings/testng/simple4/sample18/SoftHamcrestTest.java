package ru.stqa.trainings.testng.simple4.sample18;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class SoftHamcrestTest {
  
  private SoftHamcrestAssert h = new SoftHamcrestAssert();

  @Test
  public void testHardAssert() {
    assertThat("Three", 2 * 2, is(3));
    assertThat("Five", 2 * 2, is(5));
  }

  @Test
  public void testSoftAssert() {
    h.assertThat("Three", 2 * 2, is(3));
    h.assertThat("Five", 2 * 2, is(5));
    h.assertAll();
  }
}
