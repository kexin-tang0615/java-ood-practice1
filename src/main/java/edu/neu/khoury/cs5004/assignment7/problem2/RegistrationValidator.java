package edu.neu.khoury.cs5004.assignment7.problem2;

import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficCrash;
import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficViolation;

import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

/**
 * Validator that judge if a given prospective driver is qualified as a ride-sharing driver.
 */
public class RegistrationValidator {

  private static final int AGE_BAR = 21;
  private static final int MONTHS_ONE_YEAR = 12;
  private static final int SIX = 6;
  private static final int VEHICLE_AGE_BAR = 20;

  private ProspectiveDriver prospectiveDriver;
  private boolean validDriver;

  /**
   * Constructor that creates a new RegistrationValidator object, based upon all of the provided
   * input parameters.
   *
   * @param prospectiveDriver the prospective driver that applies.
   */
  public RegistrationValidator(
      ProspectiveDriver prospectiveDriver) {
    this.prospectiveDriver = prospectiveDriver;
    this.validDriver = true;
  }

  /**
   * Validate the prospective driver's age. If the prospective driver is underage (younger than 21),
   * they should not be accepted as a driver.
   */
  public void validateAge() {
    LocalDate today = LocalDate.now();
    Period age = Period.between(prospectiveDriver.getBirthDate(), today);
    if (age.getYears() < AGE_BAR) {
      this.validDriver = false;
    }
  }

  /**
   * Validate the prospective driver's driver license. 1. Are there any differences between the name
   * provided on the application and the name on the license? If yes, the prospective driver should
   * not be accepted as a driver. 2. Are there any differences between the birthdate provided on the
   * application and the date on the license? If yes, the prospective driver should not be accepted
   * as a driver. 3. Is the license issued in the US? If no, for now, the prospective driver should
   * not be accepted as a driver. 4. Was the driver license issued less than six months ago? If yes,
   * then the prospective driver should not be accepted as a driver. 5. Has the driver license
   * expired? If yes, then the prospective driver should not be accepted as a driver.
   */
  public void validateDriverLicense() {
    if (!this.prospectiveDriver.getDriverName()
        .equals(this.prospectiveDriver.getDriverLicense().getDriverName())) {
      this.validDriver = false;
      return;
    }

    if (!this.prospectiveDriver.getBirthDate()
        .equals(this.prospectiveDriver.getDriverLicense().getBirthDate())) {
      this.validDriver = false;
      return;
    }

    if (!this.prospectiveDriver.getDriverLicense().getCountryOfInsurance().equals("US")) {
      this.validDriver = false;
      return;
    }

    LocalDate today = LocalDate.now();
    Period insurancePeriod =
        Period.between(prospectiveDriver.getDriverLicense().getInsuranceDate(), today);
    if ((insurancePeriod.getYears() * MONTHS_ONE_YEAR + insurancePeriod.getMonths()) < SIX) {
      this.validDriver = false;
      return;
    }

    Period expirationPeriod =
        Period.between(today, prospectiveDriver.getDriverLicense().getExpirationDate());
    if (expirationPeriod.isNegative()) {
      this.validDriver = false;
    }
  }

  /**
   * Validate the vehicle information. Is the vehicle older than 20 years? If yes, then prospective
   * driver should not be accepted as a driver
   */
  public void validateVehicle() {
    LocalDate today = LocalDate.now();
    if (today.getYear() - prospectiveDriver.getVehicleInfo().getYear() > VEHICLE_AGE_BAR) {
      this.validDriver = false;
    }
  }

  /**
   * Validate the vehicle insurance. 1. Is the prospective driver the official owner of the vehicle?
   * If not, is the prospective driver listed as an insured driver? If no, then the prospective
   * driver should not be accepted as a driver. 2. Has the insurance expired? If yes, then the
   * prospective driver should not be accepted as a driver.
   */
  public void validateVehicleInsurance() {
    if (!this.prospectiveDriver.getDriverName()
        .equals(this.prospectiveDriver.getVehicleInfo().getOwner())
        && !(this.prospectiveDriver.getInsuranceInfo().getOtherDriver()
        .contains(this.prospectiveDriver.getDriverName()))) {
      this.validDriver = false;
      return;
    }
    LocalDate today = LocalDate.now();
    Period effectivePeriod =
        Period.between(today, prospectiveDriver.getInsuranceInfo().getExpirationDate());
    if (effectivePeriod.isNegative()) {
      this.validDriver = false;
    }
  }

  /**
   * Validate the driver's history. Does the prospective driver have any moving violations? If yes,
   * do those include reckless driving, speeding, DUI, or driving without a valid license/insurance?
   * If yes, then prospective driver should not be accepted as a driver.
   */
  public void validateDriverHistory() {

    EnumSet<MovingViolation> invalidDriverHistory =
        EnumSet.of(MovingViolation.RECKLESS,
            MovingViolation.SPEEDING,
            MovingViolation.DUI,
            MovingViolation.LICENSE_INSURANCE_ABSENCE);

    for (Violation violation : this.prospectiveDriver.getDriverHistory().getViolations()) {
      if (invalidDriverHistory.contains(violation.getViolationType())) {
        this.validDriver = false;
        return;
      }
    }
  }

  /**
   * Validate the vehicle history. Are there any crashes or moving violations committed with this
   * vehicle in the last six months? If yes, then prospective driver should not be accepted as a
   * driver.
   */
  public void validateVehicleHistory() {
    LocalDate today = LocalDate.now();

    for (TrafficCrash trafficCrash : this.prospectiveDriver.getVehicleHistory()
        .getTrafficCrashes()) {
      Crash crash = trafficCrash.getCrash();
      Period crashPeriod = Period.between(crash.getDateOfCrash(), today);
      if ((crashPeriod.getYears() * MONTHS_ONE_YEAR + crashPeriod.getMonths()) < SIX) {
        this.validDriver = false;
        return;
      }
    }

    for (TrafficViolation trafficViolation : this.prospectiveDriver.getVehicleHistory()
        .getTrafficViolations()) {
      Violation violation = trafficViolation.getViolation();
      if (!(violation.getViolationType() instanceof MovingViolation)) {
        continue;
      }
      Period violationPeriod = Period.between(violation.getDateOfViolation(), today);
      if ((violationPeriod.getYears() * MONTHS_ONE_YEAR + violationPeriod.getMonths()) < SIX) {
        this.validDriver = false;
        return;
      }
    }


  }

  /**
   * Get the validate result.
   *
   * @return the validate result. True: the driver is qualified. False: the driver is not qualified.
   */
  public boolean isValid() {
    return this.validDriver;
  }
}
