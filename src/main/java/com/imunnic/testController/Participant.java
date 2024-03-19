package com.imunnic.testController;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Markable<Result>, Identificable<Long> {
  private Long id;
  private Person<Long> person;
  private List<Result> results;
  private Integer dorsal;

  public void setPerson(Person<Long> person) {
    this.person = person;
  }

  public Person<Long> getPerson() {
    return person;
  }

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

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Long getId() {
    return id;
  }

  public Participant() {
    setResults(new ArrayList<Result>());
  }

  public Participant(Person<Long> person, Integer dorsal, List<Result> results) {
    setPerson(person);
    setDorsal(dorsal);
    setResults(results);
  }

  @Override
  public int getMark(Result result) {
    return result.getResult();
  }

  @Override
  public String toString() {
    return getDorsal() + ":" + getPerson().getName() + " - " + getPerson().getAlias();
  }
}
