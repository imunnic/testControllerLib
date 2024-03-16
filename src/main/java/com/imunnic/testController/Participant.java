package com.imunnic.testController;

import java.util.ArrayList;
import java.util.List;

public class Participant extends Person<Integer> implements Markable<Result>{
  private int dorsal;
  private List<Result> results;

  public int getDorsal() {
    return dorsal;
  }

  public void setDorsal(int dorsal) {
    this.dorsal = dorsal;
  }

  public List<Result> getResults() {
    return results;
  }
  
  public void setResults(List<Result> results) {
    this.results = results;
  }
  
  @Override
  public Integer getId() {
    return getDorsal();
  }

  public Participant() {
    super();
    setResults(new ArrayList<Result>());
  }

  public Participant(String name, String alias) {
    super(name, alias);
    setResults(new ArrayList<Result>());
  }

  public Participant(String name, int dorsal, String alias) {
    this(name,alias);
    setDorsal(dorsal);
  }
  
  public Participant(String name, String alias,int dorsal, List<Result> results) {
    this(name, dorsal, alias);
    setResults(results);
  }

  @Override
  public int getMark(Result result) {
    return result.getResult();
  }
  
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return getDorsal() + ":" + getName() + " - " + getAlias();
  }
}
