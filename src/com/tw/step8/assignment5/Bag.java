package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
  private final HashSet<Ball> balls;
  private final int capacity = 12;

  private Bag() {
    this.balls = new HashSet<>(this.capacity);
  }

  public static Bag createStore() {
    return new Bag();
  }

  public boolean add(Ball ball) {
    if (isBagFull()) return false;

    if (isReachedMaxLimit(Color.GREEN, 3)) {
      return false;
    }
    return this.balls.add(ball);
  }

  private boolean isBagFull() {
    return this.balls.size() >= this.capacity;
  }

  private boolean isReachedMaxLimit(Color color, int maxLimit) {
    long count = this.balls.stream()
            .filter(ball -> ball.getColor() == color)
            .count();
    return count >= maxLimit;
  }
}
