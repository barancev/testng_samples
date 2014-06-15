package ru.stqa.trainings.testng.simple5.sample21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametrizedTests {

  @Test(dataProvider = "users")
  public void test1(String user, String password) {
    System.out.println(user + ":" + password);
  }
  
  @DataProvider
  public Iterator<Object[]> users() {
    List<Object[]> data = new ArrayList<Object[]>();
    for (int i = 0; i < 100; i++) {
      data.add(new Object[]{
         generateRandomName(), generateRandomPassword() 
      });
    }
    return data.iterator();
  }

  private Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private Object generateRandomName() {
    return "user" + new Random().nextInt();
  }

}
