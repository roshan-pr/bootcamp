package com.tw.step8.assignment5;

import java.util.HashSet;
import java.util.function.Predicate;

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

    if (ball.isSameColor(Color.GREEN) && !isGreenAllowed()) {
      return false;
    }

    if (ball.isSameColor(Color.RED) && !isRedAllowed()) {
      return false;
    }

    if (ball.isSameColor(Color.YELLOW) && !isYellowAllowed()) {
      return false;
    }

    if (ball.isSameColor(Color.BLUE) && !isBlueAllowed()) {
      return false;
    }

    if (ball.isSameColor(Color.BLACK) && !isBlackAllowed()) {
      return false;
    }

    return this.balls.add(ball);
  }

  private boolean isBlackAllowed() {
    return countOf(Color.BLUE) < 1;
  }

  private boolean isBlueAllowed() {
    return countOf(Color.BLACK) < 1;
  }

  private boolean isGreenAllowed() {
    return countOf(Color.GREEN) < 3;
  }

  private boolean isYellowAllowed() {
    double ratio = (countOf(Color.YELLOW) + 1.0) / (this.balls.size() + 1.0);
    return ratio <= 0.4;
  }

  private boolean isRedAllowed() {
    if (isBagEmpty()) return false;

    double ratio = countOf(Color.RED) * 1.0 / countOf(Color.GREEN);
    return ratio < 2.0;
  }

  private boolean isBagEmpty() {
    return this.balls.size() == 0;
  }

  private long countOf(Color color) {
    return this.balls.stream()
            .filter(ball -> ball.isSameColor(color))
            .count();
  }

  private boolean isBagFull() {
    return this.balls.size() >= this.capacity;
  }
}
