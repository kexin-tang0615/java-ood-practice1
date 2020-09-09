package edu.neu.khoury.cs5004.assignment7.problem2;

/**
 * Crash type, and it includes the following three types: A fender-bender, A crash without bodily
 * injuries, A crash involving bodily injuries.
 */
public enum CrashType {
  /**
   * Fender bender crash type.
   */
  FENDER_BENDER("fender-bender"),
  /**
   * The No body injury.
   */
  NO_BODY_INJURY("a crash without bodily injuries"),
  /**
   * The Body injury.
   */
  BODY_INJURY("a crash involving bodily injuries");
  private String description;

  CrashType(String description) {
    this.description = description;
  }

  /**
   * Gets discription.
   *
   * @return the discription
   */
  public String getDiscription() {
    return description;
  }
}
