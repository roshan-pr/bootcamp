package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.ColorNotAllowedException;
import com.tw.step8.assignment5.exception.SizeOverflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
  @Test
  void shouldAddABall() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanTwelveBalls() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    for (int i = 0; i < 12; i++) {
      bag.add(new Ball("ball-" + i, Color.NO_COLOR));
    }

    assertThrows(SizeOverflowException.class, () -> bag.add(new Ball("ball-13", Color.GREEN)));
  }

  @Test
  void shouldNotAddMoreThanThreeGreenBalls() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.GREEN));
    bag.add(new Ball("ball-3", Color.GREEN));

    assertThrows(ColorNotAllowedException.class, () -> bag.add(new Ball("ball-4", Color.GREEN)));
  }

  @Test
  void shouldPreventAddingRedBallIfNoGreenBalls() throws ColorNotAllowedException {
    Bag bag = Bag.create();

    assertThrows(ColorNotAllowedException.class, () -> bag.add(new Ball("ball-1", Color.RED)));
  }

  @Test
  void shouldAddTwoRedBallForOneGreenBall() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));

    assertTrue(bag.add(new Ball("ball-3", Color.RED)));
  }

  @Test
  void shouldPreventAddingThreeRedBallForTwoGreenBalls() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));
    bag.add(new Ball("ball-3", Color.RED));

    assertThrows(ColorNotAllowedException.class, () -> bag.add(new Ball("ball-4", Color.RED)));
  }

  @Test
  void shouldPreventAddingYellowBallMoreThanFortyPercentOfCurrentCapacity() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));

    assertThrows(ColorNotAllowedException.class,() -> bag.add(new Ball("ball-2", Color.YELLOW)));
  }

  @Test
  void shouldAddYellowBallWhenCapacityIsLessThanFortyPercentOfCurrentCapacity() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.GREEN));
    bag.add(new Ball("ball-2", Color.RED));

    assertTrue(bag.add(new Ball("ball-3", Color.YELLOW)));
  }

  @Test
  void shouldAddBlueBallIfBlackBallIsAbsent() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.BLUE)));
  }

  @Test
  void shouldNotAddBlueBallIfBlackBallIsPresent() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.BLACK));

    assertThrows(ColorNotAllowedException.class,() -> bag.add(new Ball("ball-2", Color.BLUE)));
  }

  @Test
  void shouldAddBlackBallIfBlueBallIsAbsent() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    assertTrue(bag.add(new Ball("ball-1", Color.BLACK)));
  }

  @Test
  void shouldNotAddBlackBallIfBlueBallPresent() throws ColorNotAllowedException, SizeOverflowException {
    Bag bag = Bag.create();

    bag.add(new Ball("ball-1", Color.BLUE));

    assertThrows(ColorNotAllowedException.class,() -> bag.add(new Ball("ball-2", Color.BLACK)));
  }
}