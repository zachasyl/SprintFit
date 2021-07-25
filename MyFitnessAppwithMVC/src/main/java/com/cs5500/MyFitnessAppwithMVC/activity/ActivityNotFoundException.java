package com.cs5500.MyFitnessAppwithMVC.activity;

/**
 * This is a custom Exception that gets thrown when an Activity
 * matching a specified id is not found.
 */
public class ActivityNotFoundException extends Throwable {
  public ActivityNotFoundException(String message) {
    super(message);
  }
}
