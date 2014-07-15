package ru.stqa.trainings.testng.tricky4.sample37;

import org.testng.annotations.Test;

public class DeleteUser extends TestBase {

  private String user;
  
  public DeleteUser(String user) {
    this.user = user;
  }

  @Test
  public void testDeleteUser() {
    System.out.println("testDeleteUser " + user);
  }

}
