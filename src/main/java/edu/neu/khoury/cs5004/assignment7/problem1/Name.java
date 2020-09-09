package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.Objects;

/**
 * Class Name contains information about a name. This class is used as a part of problem1.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructor that creates a new Name object, based upon all of the provided input parameters.
   *
   * @param firstName the first name, expressed as a String
   * @param middleName the middle name, expressed as a String
   * @param lastName the last name, expressed as a String
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Instantiates a new Name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets first name as a String.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets middle name as a String.
   *
   * @return the middle name
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Gets last name as a String.
   *
   * @return the last name
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
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(getFirstName(), name.getFirstName())
        && Objects.equals(getMiddleName(), name.getMiddleName())
        && Objects.equals(getLastName(), name.getLastName());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "Name{"
        + "firstName='" + firstName + '\''
        + ", middleName='" + middleName + '\''
        + ", lastName='" + lastName + '\''
        + '}';
  }
}

