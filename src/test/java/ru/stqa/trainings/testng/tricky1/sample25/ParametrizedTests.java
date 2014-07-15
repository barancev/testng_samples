package ru.stqa.trainings.testng.tricky1.sample25;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ParametrizedTests extends TestBase {
  
  @Factory
  public Object tf() {
    return new Object[]{ new ParametrizedTests("/user.data") };
  }

  public ParametrizedTests(String resource) {
    super(resource);
  }

  @Test(dataProvider = "loadUserFromResource")
  public void test1(String user, String password) {
    System.out.println(user + ":" + password);
  }

}
