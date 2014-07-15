package ru.stqa.trainings.testng.tricky4.sample37;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class OrderByPriority implements IMethodInterceptor {

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    Collections.sort(methods, new Comparator<IMethodInstance>() {
      @Override
      public int compare(IMethodInstance o1, IMethodInstance o2) {
        HasPriority i1 = (HasPriority) o1.getInstance();
        HasPriority i2 = (HasPriority) o2.getInstance();
        return Integer.compare(i1.getPriority(), i2.getPriority());
      }
    });
    return methods;
  }

}
