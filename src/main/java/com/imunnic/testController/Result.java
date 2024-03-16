package com.imunnic.testController;

public class Result {
  private Tester tester;
  private Trial trial;
  private int grossResult;
  
  public Tester getTester() {
    return tester;
  }
  
  public void setTester(Tester tester) {
    this.tester = tester;
  }
  
  public Trial getTrial() {
    return trial;
  }
  
  public void setTrial(Trial trial) {
    this.trial = trial;
  }
  
  public int getGrossResult() {
    return grossResult;
  }
  
  public void setGrossResult(int grossResult) {
    this.grossResult = grossResult;
  }
  
  public Result() {
  }

  public Result(Tester tester, Trial trial, int grossResult) {
    this.tester = tester;
    this.trial = trial;
    this.grossResult = grossResult;
  }

  public int getResult() {
    return trial.getMark(grossResult);
  }
  
  @Override
  public String toString() {
    return "Resultado de: " + getGrossResult() + "\n" + getTester().toString() + "\nPrueba: " + trial.getName();
  }
}
