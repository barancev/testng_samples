package ru.stqa.trainings.testng.tricky3.sample33;

import org.testng.annotations.Test;

public class SampleTest {

  @Test(enabled = false, dataProvider = "csvDataProvider", dataProviderClass = CsvDataProviders.class)
  @CsvDataSource("data.csv")
  public void testCsv(String par1, String par2, String par3) {
    System.out.println("Hello, " + par1 + "," + par2 + "," + par3);
  }

  @Test(enabled = false, dataProvider = "lazyCsvDataProvider", dataProviderClass = CsvDataProviders.class)
  @CsvDataSource("data.csv")
  public void testLazyCsv(String par1, String par2, String par3) {
    System.out.println("Hello, " + par1 + "," + par2 + "," + par3);
  }

}
