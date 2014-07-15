package ru.stqa.trainings.testng.tricky4.sample37;

public class TestBase implements HasPriority {

  private int p;

  @Override
  public int getPriority() {
    return p;
  }

  @Override
  public void setPriority(int p) {
    this.p = p;
  }

}
