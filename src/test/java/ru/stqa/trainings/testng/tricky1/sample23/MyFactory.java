package ru.stqa.trainings.testng.tricky1.sample23;

import org.testng.annotations.Factory;

public class MyFactory {

  @Factory
  public Object[] tf() {
    Object[] tests = new Object[3];
    for (int i = 0; i < 3; i++) {
      tests[i] = new MyTest();
    }
    return tests;
  }
}
