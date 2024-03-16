package com.imunnic.testController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test implements Datable, Identificable<Integer>, Sortable, Markable<Participant>{
  private Integer id;
  private String name;
  private String description;
  private LocalDate date;
  private List<Participant> participants;
  private List<Tester> testers;
  private List<Trial> trials;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Participant> getParticipants() {
    return participants;
  }

  public void setParticipants(List<Participant> participants) {
    this.participants = participants;
  }

  public List<Tester> getTesters() {
    return testers;
  }

  public void setTesters(List<Tester> testers) {
    this.testers = testers;
  }

  public List<Trial> getTrials() {
    return trials;
  }

  public void setTrials(List<Trial> trials) {
    this.trials = trials;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public void sort() {
    participants.sort((a,b) -> getMark(b)-getMark(a));
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public LocalDate getDate() {
    return date;
  }

  @Override
  public int getMark(Participant participant) {
    return participant.getResults().stream().mapToInt(Result::getResult).sum();
  }

  public Test() {
    setParticipants(new ArrayList<Participant>());
    setTesters(new ArrayList<Tester>());
    setTrials(new ArrayList<Trial>());
  }
  
  public Test(Integer id, String name, String description, LocalDate date,
      List<Participant> participants, List<Tester> testers, List<Trial> trials) {
    setId(id);
    setName(name);
    setDescription(description);
    setDate(date);
    setParticipants(participants);
    setTesters(testers);
    setTrials(trials);
  }
  
  @Override
  public String toString() {    
    return getName() + ":\n" + getDescription() + "\nFecha: " + getDate().toString();
  }
}
