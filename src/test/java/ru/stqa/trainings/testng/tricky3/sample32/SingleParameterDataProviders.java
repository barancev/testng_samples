package ru.stqa.trainings.testng.tricky3.sample32;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class SingleParameterDataProviders {

  @DataProvider
  public static Object[][] arrayDataProvider(Method m) throws NoSuchFieldException, IllegalAccessException {
    if (m.isAnnotationPresent(SingleParameterDataSource.class)) {
      if (m.getParameterTypes().length != 1) {
        throw new Error("Method should have a single parameter: " + m);
      }
      SingleParameterDataSource dataSource = m.getAnnotation(SingleParameterDataSource.class);
      Class clazz = dataSource.clazz();
      if (clazz.equals(void.class)) {
        clazz = m.getDeclaringClass();
      }

      Field field = clazz.getField(dataSource.value());
      Object[] data = (Object[]) field.get(null);

      Object[][] result = new Object[data.length][];
      for (int i = 0; i < data.length; i++) {
        result[i] = new Object[]{data[i]};
      }
      return result;
    } else {
      throw new Error("There is no @SingleParameterDataSource annotation on method " + m);
    }
  }

  @DataProvider
  public static Object[][] listDataProvider(Method m) throws NoSuchFieldException, IllegalAccessException {
    if (m.isAnnotationPresent(SingleParameterDataSource.class)) {
      if (m.getParameterTypes().length != 1) {
        throw new Error("Method should have a single parameter: " + m);
      }
      SingleParameterDataSource dataSource = m.getAnnotation(SingleParameterDataSource.class);
      Class clazz = dataSource.clazz();
      if (clazz.equals(void.class)) {
        clazz = m.getDeclaringClass();
      }

      Field field = clazz.getField(dataSource.value());
      List<Object> data = (List<Object>) field.get(null);

      Object[][] result = new Object[data.size()][];
      for (int i = 0; i < data.size(); i++) {
        result[i] = new Object[]{data.get(i)};
      }
      return result;
    } else {
      throw new Error("There is no @SingleParameterDataSource annotation on method " + m);
    }
  }
}
