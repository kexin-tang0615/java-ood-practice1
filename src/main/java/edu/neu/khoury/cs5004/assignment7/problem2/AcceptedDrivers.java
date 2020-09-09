package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Set;

/**
 * Class AcceptedDrivers contains information that filter the applying drivers. This class is used
 * as a part of problem2.
 */
public class AcceptedDrivers {

  private Set<ProspectiveDriver> driverSet;

  /**
   * Constructor that creates a new AcceptedDrivers object, based upon all of the provided input
   * parameters.
   * Create an empty filter class.
   */
  public AcceptedDrivers() {
    this.driverSet = new HashSet<>();
  }

  /**
   * Filter the input applying driver. If the driver is qualified, put it in the existing driver
   * set. If the driver is not qualified, just print out an error message.
   *
   * @param prospectiveDriver the applying perspective driver.
   * @return the set of qualified drivers we have so far.
   */
  public Set<ProspectiveDriver> addDriver(ProspectiveDriver prospectiveDriver) {
    RegistrationValidator registrationValidator = new RegistrationValidator(prospectiveDriver);
    registrationValidator.validateAge();
    registrationValidator.validateDriverHistory();
    registrationValidator.validateDriverLicense();
    registrationValidator.validateVehicleHistory();
    registrationValidator.validateVehicleInsurance();
    registrationValidator.validateVehicle();
    if (registrationValidator.isValid()) {
      this.driverSet.add(prospectiveDriver);
    } else {
      System.out.println("This is not a valid driver!");
    }
    return this.driverSet;
  }

}
