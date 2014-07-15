package ru.stqa.trainings.testng.tricky4.sample37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;

import ru.stqa.trainings.testng.simple5.sample22.DataProviders;

@Listeners(OrderByPriority.class)
public class MyFactory {

  @Factory
  public Object[] tf() throws IOException {
    List<Object> tests = new ArrayList<Object>();
    List<String[]> data = loadUserFromResource("/user.data");
    int p = 0;
    for (String[] dataItem : data) {
      CreateUser create = new CreateUser(dataItem[0], dataItem[1]);
      create.setPriority(p++);
      tests.add(create);
      DeleteUser delete = new DeleteUser(dataItem[0]);
      delete.setPriority(p++);
      tests.add(delete);
    }
    return (Object[]) tests.toArray(new Object[tests.size()]);
  }

  public List<String[]> loadUserFromResource(String resource) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
        DataProviders.class.getResourceAsStream(resource)));
    
    List<String[]> userData = new ArrayList<String[]>();
    String line = in.readLine();
    while (line != null) {
      userData.add(line.split(";"));
      line = in.readLine();
    }
    
    in.close();
    
    return userData;
  }

}
