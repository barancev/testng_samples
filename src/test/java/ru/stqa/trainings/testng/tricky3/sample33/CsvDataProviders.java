package ru.stqa.trainings.testng.tricky3.sample33;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvDataProviders {

  @DataProvider
  public static Object[][] csvDataProvider(Method m) throws IOException {
    if (m.isAnnotationPresent(CsvDataSource.class)) {
      int length = m.getParameterTypes().length;
      CsvDataSource dataSource = m.getAnnotation(CsvDataSource.class);
      File csvFile = new File(dataSource.value());

      List<Object[]> result = new ArrayList<Object[]>();
      CSVReader reader = new CSVReader(new FileReader(csvFile));
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        System.out.println(Arrays.toString(nextLine));
        Object[] parameters = new Object[length];
        for (int i = 0; i < length; i++) {
          if (i < nextLine.length) {
            parameters[i] = nextLine[i];
          } else {
            parameters[i] = null;
          }
        }
        result.add(parameters);
      }

      return result.toArray(new Object[result.size()][]);
    } else {
      throw new Error("There is no @CsvDataSource annotation on method " + m);
    }
  }

  @DataProvider
  public static Iterator<Object[]> lazyCsvDataProvider(Method m) throws IOException {
    if (m.isAnnotationPresent(CsvDataSource.class)) {
      int length = m.getParameterTypes().length;
      CsvDataSource dataSource = m.getAnnotation(CsvDataSource.class);
      File csvFile = new File(dataSource.value());
      return new CsvFileIterator(csvFile, length);
    } else {
      throw new Error("There is no @CsvDataSource annotation on method " + m);
    }
  }

  private static class CsvFileIterator implements Iterator<Object[]> {

    private final CSVReader reader;
    private int length;
    private String[] nextLine;

    public CsvFileIterator(File csvFile, int length) throws FileNotFoundException {
      this.length = length;
      reader = new CSVReader(new FileReader(csvFile));
    }

    @Override
    public boolean hasNext() {
      try {
        nextLine = reader.readNext();
        return nextLine != null;
      } catch (IOException e) {
        return false;
      }
    }

    @Override
    public Object[] next() {
      if (nextLine == null) {
        return null;
      }
      System.out.println(Arrays.toString(nextLine));
      Object[] parameters = new Object[length];
      for (int i = 0; i < length; i++) {
        if (i < nextLine.length) {
          parameters[i] = nextLine[i];
        } else {
          parameters[i] = null;
        }
      }
      return parameters;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
