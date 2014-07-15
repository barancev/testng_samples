package ru.stqa.trainings.testng.tricky4.sample35;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(RunTwiceInterceptor.class)
public class UnstableTest {
  
  private static int attempt = 1;
  
  @Test
  public void randomlyFailingTest() {
    if (attempt == 2) {
      attempt = 1;

    } else {
      Assert.fail("Failed on " + (attempt++) + " attempt");
    }
  }

}
