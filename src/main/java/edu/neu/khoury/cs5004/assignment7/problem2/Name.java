package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * Class Name contains information about a prospective driver’s first and last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructor that creates a new Name object, based upon all of the provided input parameters.
   *
   * @param firstName driver's first name.
   * @param lastName driver's last name.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get the driver's first name.
   *
   * @return the driver's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the driver's last name.
   *
   * @return the driver's last name.
   */
  public String getLastName() {
    return lastName;
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
    if (!(object instanceof Name)) {
      return false;
    }
    Name name = (Name) object;
    return Objects.equals(getFirstName(), name.getFirstName())
        && Objects.equals(getLastName(), name.getLastName());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName());
  }
}
