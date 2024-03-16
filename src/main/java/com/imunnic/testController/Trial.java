package com.imunnic.testController;

public enum Trial implements Markable<Integer>{
  BURPEES("Burpees", "Completa tantos burpees como sea posible en un tiempo determinado") {

      @Override
      public int getMark(Integer result) {
        return result*3;
      }
  },
  PUSH_UPS("Push ups", "Completa tantas flexiones como sea posible en un tiempo determinado") {

    @Override
    public int getMark(Integer result) {
      return result;
    }

  },
  PULL_UPS("Pull ups", "Completa tantas dominadas como sea posible en un tiempo determinado") {

      @Override
      public int getMark(Integer result) {
        return result*2;
      }
  },
  RUN("Run", "Corre una distancia determinada en el menor tiempo posible") {
    //tiempo medido en minutos
      @Override
      public int getMark(Integer result) {
        return 150/result;
      }
  },
  DEVIL_PRESS("Devil press", "Completa tantos devil press como sea posible en un tiempo determinado") {

    @Override
    public int getMark(Integer result) {
      return result*4;
    }

  };

  private final String name;
  private final String description;

  Trial(String name, String description) {
      this.name = name;
      this.description = description;
  }

  public String getName() {
      return name;
  }

  public String getDescription() {
      return description;
  }

  @Override
  public String toString() {
    return getName() + "\n" + getDescription();
  }
}
