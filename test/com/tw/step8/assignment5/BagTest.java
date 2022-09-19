package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

class BagTest {
  @Test
  void shouldStoreABall() {
    Bag bag = Bag.createStore();
    bag.add(new Ball("ball-1"));
  }
}