package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
  @Test
  void shouldStoreABall() {
    Store store = new Store();
    store.add(new Ball("ball-1"));
  }
}