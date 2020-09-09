package edu.neu.khoury.cs5004.assignment7.problem2;


import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Violation contains information about a violation. This class is used as a part of
 * problem2.
 */
public class Violation {

  private IViolation violationType;
  private LocalDate dateOfViolation;

  /**
   * Constructor that creates a new Violation object, based upon all of the provided input
   * parameters.
   *
   * @param violationType the type of the violation.
   * @param dateOfViolation the date when the violation happened.
   */
  public Violation(IViolation violationType, LocalDate dateOfViolation) {
    this.violationType = violationType;
    this.dateOfViolation = dateOfViolation;
  }

  /**
   * Get the type of the violation.
   *
   * @return the type of the violation.
   */
  public IViolation getViolationType() {
    return violationType;
  }

  /**
   * Get the date when the violation happened.
   *
   * @return the date when the violation happened.
   */
  public LocalDate getDateOfViolation() {
    return dateOfViolation;
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
    if (!(object instanceof Violation)) {
      return false;
    }
    Violation violation = (Violation) object;
    return Objects.equals(getViolationType(), violation.getViolationType())
        && Objects.equals(getDateOfViolation(), violation.getDateOfViolation());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getViolationType(), getDateOfViolation());
  }
}
