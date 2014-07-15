package ru.stqa.trainings.testng.tricky1.sample26;

import org.testng.annotations.Test;

public class DeleteUser {

  private String user;
  
  public DeleteUser(String user) {
    this.user = user;
  }

  @Test
  public void testDeleteUser() {
    System.out.println("testDeleteUser " + user);
  }

}
