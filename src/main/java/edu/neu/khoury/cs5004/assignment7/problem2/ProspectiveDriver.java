package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;

/**
 * Class ProspectiveDriver contains information about the prospective driver that submit the
 * application.
 */
public class ProspectiveDriver {

  private Name driverName;
  private LocalDate birthDate;
  private DriverLicense driverLicense;
  private VehicleInfo vehicleInfo;
  private InsuranceInfo insuranceInfo;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;


  /**
   * Constructor that creates a new ProspectiveDriver object, based upon all of the provided input
   * parameters.
   *
   * @param driverName the driver's name.
   * @param birthDate the driver's birth date.
   * @param driverLicense the information for driver's license.
   * @param vehicleInfo the information for the driver's vehicle.
   * @param insuranceInfo the information for the vehicle's insurance.
   * @param driverHistory the information for the driver's history.
   * @param vehicleHistory the information for the vehicle's history.
   */
  public ProspectiveDriver(Name driverName,
      LocalDate birthDate,
      DriverLicense driverLicense,
      VehicleInfo vehicleInfo,
      InsuranceInfo insuranceInfo,
      DriverHistory driverHistory,
      VehicleHistory vehicleHistory) {
    this.driverName = driverName;
    this.birthDate = birthDate;
    this.driverLicense = driverLicense;
    this.vehicleInfo = vehicleInfo;
    this.insuranceInfo = insuranceInfo;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Get the driver's name.
   *
   * @return the driver's name.
   */
  public Name getDriverName() {
    return driverName;
  }

  /**
   * Get the driver's birth date.
   *
   * @return the driver's birth date.
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Get the information for driver's license.
   *
   * @return the information for driver's license.
   */
  public DriverLicense getDriverLicense() {
    return driverLicense;
  }

  /**
   * Get the information for the driver's vehicle.
   *
   * @return the information for the driver's vehicle.
   */
  public VehicleInfo getVehicleInfo() {
    return vehicleInfo;
  }

  /**
   * Get the information for the vehicle's insurance.
   *
   * @return the information for the vehicle's insurance.
   */
  public InsuranceInfo getInsuranceInfo() {
    return insuranceInfo;
  }

  /**
   * Get the information for the driver's history.
   *
   * @return the information for the driver's history.
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Get the information for the vehicle's history.
   *
   * @return the information for the vehicle's history.
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }
}
