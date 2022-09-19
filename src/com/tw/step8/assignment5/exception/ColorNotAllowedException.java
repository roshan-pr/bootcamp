package com.tw.step8.assignment5.exception;

import com.tw.step8.assignment5.Color;

public class ColorNotAllowedException extends Throwable {
  private final Color color;

  public ColorNotAllowedException(Color color) {
    super();
    this.color = color;
  }

  @Override
  public String getMessage() {
    return String.format("%s not allowed in the bag", this.color);
  }
}
