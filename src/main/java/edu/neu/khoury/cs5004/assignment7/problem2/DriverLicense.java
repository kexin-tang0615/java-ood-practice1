package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Information about a prospective driver’s driver license,
 * including information about the license unique number, a driver’s name, a driver’s
 * address, a driver’s birthdate, country and state of issuance, and issuance and expiration
 * date.
 */
public class DriverLicense {

  private String licenseNumber;
  private Name driverName;
  private String address;
  private LocalDate birthDate;
  private String countryOfInsurance;
  private String stateOfInsurance;
  private LocalDate insuranceDate;
  private LocalDate expirationDate;

  /**
   * Constructor.
   * @param licenseNumber the driver license unique number.
   * @param driverName the driver's name.
   * @param address the driver's address.
   * @param birthDate the driver's birth date.
   * @param countryOfInsurance country where the license was issued.
   * @param stateOfInsurance state where the license was issued.
   * @param insuranceDate the date when the license was issued.
   * @param expirationDate the date when the license expires.
   */
  public DriverLicense(String licenseNumber,
      Name driverName,
      String address,
      LocalDate birthDate,
      String countryOfInsurance,
      String stateOfInsurance,
      LocalDate insuranceDate,
      LocalDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.driverName = driverName;
    this.address = address;
    this.birthDate = birthDate;
    this.countryOfInsurance = countryOfInsurance;
    this.stateOfInsurance = stateOfInsurance;
    this.insuranceDate = insuranceDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Get the driver license unique number.
   * @return the driver license unique number.
   */
  public String getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * Get the driver's name.
   * @return the driver's name.
   */
  public Name getDriverName() {
    return driverName;
  }

  /**
   * Get the driver's address.
   * @return the driver's address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Get the driver's birth date.
   * @return the driver's birth date.
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Get country where the license was issued.
   * @return country where the license was issued.
   */
  public String getCountryOfInsurance() {
    return countryOfInsurance;
  }

  /**
   * Get state where the license was issued.
   * @return state where the license was issued.
   */
  public String getStateOfInsurance() {
    return stateOfInsurance;
  }

  /**
   * Get the date when the license was issued.
   * @return the date when the license was issued.
   */
  public LocalDate getInsuranceDate() {
    return insuranceDate;
  }

  /**
   * Get the date when the license expires.
   * @return the date when the license expires.
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
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
    if (!(object instanceof DriverLicense)) {
      return false;
    }
    DriverLicense that = (DriverLicense) object;
    return Objects.equals(getLicenseNumber(), that.getLicenseNumber())
        && Objects.equals(getDriverName(), that.getDriverName())
        && Objects.equals(getAddress(), that.getAddress())
        && Objects.equals(getBirthDate(), that.getBirthDate())
        && Objects.equals(getCountryOfInsurance(), that.getCountryOfInsurance())
        && Objects.equals(getStateOfInsurance(), that.getStateOfInsurance())
        && Objects.equals(getInsuranceDate(), that.getInsuranceDate())
        && Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLicenseNumber(), getDriverName(), getAddress(), getBirthDate(),
        getCountryOfInsurance(), getStateOfInsurance(), getInsuranceDate(), getExpirationDate());
  }
}
