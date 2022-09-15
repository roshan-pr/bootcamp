package com.tw.step8.chance.exception;

public class InvalidProbabilityException extends Throwable {
  private final double probability;

  public InvalidProbabilityException(double probability) {
    this.probability = probability;
  }

  @Override
  public String getMessage() {
    return probability + "is an invalid value!";
  }
}
