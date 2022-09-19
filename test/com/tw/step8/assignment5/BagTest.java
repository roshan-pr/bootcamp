package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
  @Test
  void shouldAddABall() {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanTwelveBalls() {
    Bag bag = Bag.create();

    for (int i = 0; i < 12; i++) {
      bag.add(new Ball("ball-" + i, Color.NOCOLOR));
    }

    assertFalse(bag.add(new Ball("ball-13", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanThreeGreenBalls() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-1", Color.GREEN));

    assertFalse(bag.add(new Ball("ball-1", Color.GREEN)));
  }

  @Test
  void shouldPreventAddingRedBallIfNoGreenBalls() {
    Bag bag = Bag.create();

    assertFalse(bag.add(new Ball("ball-1", Color.RED)));
  }

  @Test
  void shouldAddTwoRedBallForOneGreenBall() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-3", Color.RED));
    assertTrue(bag.add(new Ball("ball-4", Color.RED)));
  }

  @Test
  void shouldPreventAddingThreeRedBallForTwoGreenBalls() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));
    bag.add(new Ball("ball-3", Color.RED));
    assertFalse(bag.add(new Ball("ball-4", Color.RED)));
  }
}