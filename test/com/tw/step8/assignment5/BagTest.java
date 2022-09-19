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
      bag.add(new Ball("ball-" + i, Color.NO_COLOR));
    }

    assertFalse(bag.add(new Ball("ball-13", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanThreeGreenBalls() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.GREEN));
    bag.add(new Ball("ball-3", Color.GREEN));

    assertFalse(bag.add(new Ball("ball-4", Color.GREEN)));
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
    bag.add(new Ball("ball-2", Color.RED));

    assertTrue(bag.add(new Ball("ball-3", Color.RED)));
  }

  @Test
  void shouldPreventAddingThreeRedBallForTwoGreenBalls() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));
    bag.add(new Ball("ball-3", Color.RED));

    assertFalse(bag.add(new Ball("ball-4", Color.RED)));
  }

  @Test
  void shouldPreventAddingYellowBallMoreThanFortyPercentOfCurrentCapacity() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));

    assertFalse(bag.add(new Ball("ball-2", Color.YELLOW)));
  }

  @Test
  void shouldAddYellowBallWhenCapacityIsLessThanFortyPercentOfCurrentCapacity() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));

    assertTrue(bag.add(new Ball("ball-3", Color.YELLOW)));
  }

  @Test
  void shouldAddBlueBallIfBlackBallIsAbsent() {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.BLUE)));
  }

  @Test
  void shouldNotAddBlueBallIfBlackBallIsPresent() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.BLACK));

    assertFalse(bag.add(new Ball("ball-2", Color.BLUE)));
  }

  @Test
  void shouldAddBlackBallIfBlueBallIsAbsent() {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.BLACK)));
  }

  @Test
  void shouldNotAddBlackBallIfBlueBallPresent() {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.BLUE));

    assertFalse(bag.add(new Ball("ball-2", Color.BLACK)));
  }
}