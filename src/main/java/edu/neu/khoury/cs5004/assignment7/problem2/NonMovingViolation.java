package edu.neu.khoury.cs5004.assignment7.problem2;

/**
 * Non-moving violation.
 */
public enum NonMovingViolation implements IViolation {
  /**
   * The Parking.
   */
  PARKING("Parking violation"),
  /**
   * The Paperwork.
   */
  PAPERWORK("Paperwork issues"),
  /**
   * The Vehicle problem.
   */
  VEHICLE_PROBLEM("Problem with the vehicle");

  private String description;

  NonMovingViolation(String description) {
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
