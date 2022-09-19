package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
  private final HashSet<Ball> balls;

  private Bag() {
    this.balls = new HashSet<>(12);
  }

  public static Bag createStore() {
    return new Bag();
  }

  public boolean add(Ball ball) {
    if (balls.size() >= 12){
      return false;
    }
    return balls.add(ball);
  }
}
