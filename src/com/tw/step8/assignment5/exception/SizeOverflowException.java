package com.tw.step8.assignment5.exception;

public class SizeOverflowException extends Throwable {
  @Override
  public String getMessage() {
    return "Size Overflow";
  }
}
