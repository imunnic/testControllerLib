package com.imunnic.testController;

import java.io.Serializable;

public abstract class Person<T extends Serializable> implements Identificable<T>{

  private String name;
  private String alias;

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getAlias() {
    return alias;
  }
  
  public void setAlias(String alias) {
    this.alias = alias;
  }
  
  public Person() {
  }
  
  public Person(String name, String alias) {
    setName(name);
    setAlias(alias);
  }
  
  
  
  
}
