package ru.stqa.trainings.testng.tricky4.sample35;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class RunTwiceInterceptor implements IHookable {

  @Override
  public void run(IHookCallBack callback, ITestResult res) {
    System.out.println("Starting " +  res.getName());
    callback.runTestMethod(res);
    if (res.getThrowable() != null) {
      res.setThrowable(null);
      System.out.println("Second attempt " +  res.getName());
      callback.runTestMethod(res);
    }
  }

}
