package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * Class InsuranceInfo contains Information about the vehicle’s official owner, other
 * people covered by insurance as drivers, and the expiration date of the insurance.
 */
public class InsuranceInfo {

  private Name officialOwner;
  private Set<Name> otherDriver;
  private LocalDate expirationDate;

  /**
   * Constructor that creates a new InsuranceInfo object, based upon all of the provided input
   * parameters.
   *
   * @param officialOwner the owner for this vehicle.
   * @param otherDriver Set of other people covered by this insurance.
   * @param expirationDate the expiration data of the insurance.
   */
  public InsuranceInfo(Name officialOwner,
      Set<Name> otherDriver, LocalDate expirationDate) {
    this.officialOwner = officialOwner;
    this.otherDriver = otherDriver;
    this.expirationDate = expirationDate;
  }

  /**
   * Get the owner for this vehicle.
   * @return the owner for this vehicle.
   */
  public Name getOfficialOwner() {
    return this.officialOwner;
  }

  /**
   * Get the set of other people covered by this insurance.
   * @return the set of other people covered by this insurance.
   */
  public Set<Name> getOtherDriver() {
    return this.otherDriver;
  }

  /**
   * Get the expiration data of the insurance.
   * @return the expiration data of the insurance.
   */
  public LocalDate getExpirationDate() {
    return this.expirationDate;
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
    if (!(object instanceof InsuranceInfo)) {
      return false;
    }
    InsuranceInfo that = (InsuranceInfo) object;
    return Objects.equals(getOfficialOwner(), that.getOfficialOwner())
        && Objects.equals(getOtherDriver(), that.getOtherDriver())
        && Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getOfficialOwner(), getOtherDriver(), getExpirationDate());
  }
}
