package com.tw.step8.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @org.junit.jupiter.api.Test
  void shouldFindAreaOfGivenRectangle() {
    Rectangle rectangle = new Rectangle(10, 20);
    assertEquals(200, rectangle.area());
  }

  @Test
  void shouldFindPerimeterOfGivenRectangle() {
    Rectangle rectangle = new Rectangle(5, 10);
    assertEquals(30, rectangle.perimeter());

  }
}