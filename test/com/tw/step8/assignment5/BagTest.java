package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
  @Test
  void shouldAddABall() {
    Bag bag = Bag.createStore();
    assertTrue(bag.add(new Ball("ball-1", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanThreeGreenBalls() {
    Bag bag = Bag.createStore();
    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-1", Color.GREEN));
    assertFalse(bag.add(new Ball("ball-1", Color.GREEN)));
  }
}