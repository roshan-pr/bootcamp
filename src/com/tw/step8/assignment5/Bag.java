package com.tw.step8.assignment5;

import java.util.HashSet;

// As a wizard I’d like a bag that prevents me from having more than double the number of red balls as there are green balls
// given ball is red ?

public class Bag {
  private final HashSet<Ball> balls;
  private final int capacity = 12;

  private Bag() {
    this.balls = new HashSet<>(this.capacity);
  }

  public static Bag create() {
    return new Bag();
  }

  public boolean add(Ball ball) {
    if (isBagFull()) return false;

    int greenBallsLimit = 3;
    if (isReachedMaxLimit(Color.GREEN, greenBallsLimit)) {
      return false;
    }

    if (ball.getColor() == Color.RED && !isRedAllowed()) {
      return false;
    }

    return this.balls.add(ball);
  }

  private boolean isRedAllowed() {
    if (isBagEmpty()) {
      return false;
    }
    long ratio = countOf(Color.RED) / countOf(Color.GREEN);
    return ratio < 2.0;
  }

  private boolean isBagEmpty() {
    return this.balls.size() == 0;
  }

  private long countOf(Color color) {
    return this.balls.stream()
            .filter(ball -> ball.getColor() == color)
            .count();
  }

  private boolean isBagFull() {
    return this.balls.size() >= this.capacity;
  }

  private boolean isReachedMaxLimit(Color color, int maxLimit) {
    return countOf(color) >= maxLimit;
  }
}
