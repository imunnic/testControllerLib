package com.imunnic.testController;

public class Tester extends Person<Integer> {
  private int testerId;

  public int getTesterId() {
    return testerId;
  }

  public void setTesterId(int testerId) {
    this.testerId = testerId;
  }

  @Override
  public Integer getId() {
    return getTesterId();
  }

  public Tester() {
    super();
  }

  public Tester(String name, String alias) {
    super(name, alias);
  }

  public Tester(String name, String alias,int testerId) {
    super(name, alias);
    setTesterId(testerId);
  }
  
  public Result certifyResult(Trial trial, int grossResult ) {
    Result comeback = new Result(this, trial, grossResult);
    return comeback;
  }
  
  public void asignResult(Participant participant, Result result) {
    participant.getResults().add(result);
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Juez: " + getName();
  }
}
