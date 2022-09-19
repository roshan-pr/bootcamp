package com.tw.step8.assignment5;

import java.util.HashSet;

public class Store {
  private final HashSet balls;

  public Store() {
    this.balls = new HashSet(12);
  }

  public boolean add(Ball ball) {
    return balls.add(ball);
  }
}
