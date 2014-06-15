package ru.stqa.trainings.testng.simple5.sample22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {

  @DataProvider
  public static Iterator<Object[]> loadUserFromFile() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
        DataProviders.class.getResourceAsStream("/user.data")));
    
    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null) {
      userData.add(line.split(";"));
      line = in.readLine();
    }
    
    in.close();
    
    return userData.iterator();
  }

}
