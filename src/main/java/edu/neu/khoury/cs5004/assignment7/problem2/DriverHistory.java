package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class DriverHistory contains information about all traffic violations committed by the
 * prospective driver, including the date of violation, and a type of violation.
 */
public class DriverHistory {

  private Set<Violation> violations;

  /**
   * Constructor that creates a new DriverHistory object, based upon all of the provided input
   * parameters.
   * Create an empty driver history.
   */
  public DriverHistory() {
    this.violations = new HashSet<Violation>();
  }

  /**
   * Add violation to the history.
   * @param violation a Violation object
   */
  public void addViolation(Violation violation) {
    this.violations.add(violation);
  }

  /**
   * Get the set of violations associated with the driver.
   * @return set of violations associated with the driver.
   */
  public Set<Violation> getViolations() {
    return violations;
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof DriverHistory)) {
      return false;
    }
    DriverHistory that = (DriverHistory) object;
    return Objects.equals(getViolations(), that.getViolations());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getViolations());
  }
}
