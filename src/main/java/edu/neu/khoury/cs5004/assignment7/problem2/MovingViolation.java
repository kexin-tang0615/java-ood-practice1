package edu.neu.khoury.cs5004.assignment7.problem2;

/**
 * Moving violation.
 */
public enum MovingViolation implements IViolation {
  /**
   * The Distracted.
   */
  DISTRACTED("Distracted driving"),
  /**
   * The Reckless.
   */
  RECKLESS("Reckless driving"),
  /**
   * Speeding moving violation.
   */
  SPEEDING("Speeding"),
  /**
   * The Dui.
   */
  DUI("Driving under influence"),
  /**
   * The Sign failure.
   */
  SIGN_FAILURE("Failure to respect traffic signs"),
  /**
   * The License insurance absence.
   */
  LICENSE_INSURANCE_ABSENCE("Driving without a valid license and/or insurance");

  private String description;

  MovingViolation(String description) {
    this.description = description;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}
