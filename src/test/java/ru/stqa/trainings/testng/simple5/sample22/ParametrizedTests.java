package ru.stqa.trainings.testng.simple5.sample22;

import org.testng.annotations.Test;

public class ParametrizedTests {

  @Test(dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
  public void test1(String user, String password) {
    System.out.println(user + ":" + password);
  }

}
