package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficCrash;
import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficViolation;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class RegistrationValidatorTest {

  private RegistrationValidator registrationValidator1;
  private ProspectiveDriver prospectiveDriver1;
  private RegistrationValidator registrationValidator2;
  private ProspectiveDriver prospectiveDriver2;
  private RegistrationValidator registrationValidator3;
  private ProspectiveDriver prospectiveDriver3;


  @Before
  public void setUp() throws Exception {
    Name driverName = new Name("Dharma", "Alpha");

    LocalDate birthDate1 = LocalDate.of(1995, 10, 14);

    LocalDate insuranceDate1 = LocalDate.of(2013, 5, 19);
    LocalDate expirationDate1 = LocalDate.of(2023, 5, 18);
    DriverLicense driverLicense1 = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate1, "US", "AL", insuranceDate1, expirationDate1);

    VehicleInfo vehicleInfo1 = new VehicleInfo("Toyota", "Camery", 2011, driverName);

    Name driver1 = new Name("Ben", "Ben");
    Name driver2 = new Name("Kumo", "Ooki");
    Set<Name> otherDrivers = new HashSet<>();
    otherDrivers.add(driver1);
    otherDrivers.add(driver2);
    LocalDate insuranceExpirationDate1 = LocalDate.of(2020, 11, 12);
    InsuranceInfo insuranceInfo1 = new InsuranceInfo(driverName, otherDrivers,
        insuranceExpirationDate1);

    LocalDate violationDate1 = LocalDate.of(2018, 12, 12);
    LocalDate violationDate2 = LocalDate.of(2019, 3, 13);
    Violation violation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation violation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    DriverHistory driverHistory1 = new DriverHistory();
    driverHistory1.addViolation(violation1);
    driverHistory1.addViolation(violation2);

    LocalDate date1 = LocalDate.of(2012, 11, 12);
    LocalDate date2 = LocalDate.of(2018, 2, 23);
    Violation violation3 = new Violation(MovingViolation.DUI, date1);
    Violation violation4 = new Violation(NonMovingViolation.PARKING, date2);
    TrafficViolation trafficViolation1 = new TrafficViolation(violation3, driverName);
    TrafficViolation trafficViolation2 = new TrafficViolation(violation4, driverName);
    Crash crash1 = new Crash(CrashType.BODY_INJURY, date2);
    Crash crash2 = new Crash(CrashType.FENDER_BENDER, date1);
    TrafficCrash trafficCrash1 = new TrafficCrash(crash1, driverName);
    TrafficCrash trafficCrash2 = new TrafficCrash(crash2, driverName);
    VehicleHistory vehicleHistory1 = new VehicleHistory();
    vehicleHistory1.addTrafficViolations(trafficViolation1);
    vehicleHistory1.addTrafficViolations(trafficViolation2);
    vehicleHistory1.addTrafficCrash(trafficCrash1);
    vehicleHistory1.addTrafficCrash(trafficCrash2);

    prospectiveDriver1 = new ProspectiveDriver(driverName, birthDate1, driverLicense1,
        vehicleInfo1, insuranceInfo1, driverHistory1, vehicleHistory1);

    registrationValidator1 = new RegistrationValidator(prospectiveDriver1);

    LocalDate birthDate2 = LocalDate.of(2005, 10, 14);

    LocalDate insuranceDate2 = LocalDate.of(2013, 5, 19);
    LocalDate expirationDate2 = LocalDate.of(2017, 5, 18);
    DriverLicense driverLicense2 = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate1, "Canada", "AL", insuranceDate2, expirationDate2);

    VehicleInfo vehicleInfo2 = new VehicleInfo("Toyota", "Camery", 1990, driverName);

    LocalDate insuranceExpirationDate2 = LocalDate.of(2018, 11, 12);
    InsuranceInfo insuranceInfo2 = new InsuranceInfo(driverName, otherDrivers,
        insuranceExpirationDate2);

    Violation violation5 = new Violation(MovingViolation.DUI, violationDate1);
    Violation violation6 = new Violation(NonMovingViolation.PARKING, violationDate2);
    DriverHistory driverHistory2 = new DriverHistory();
    driverHistory2.addViolation(violation5);
    driverHistory2.addViolation(violation6);

    LocalDate date3 = LocalDate.of(2019, 7, 12);
    LocalDate date4 = LocalDate.of(2019, 2, 23);
    Violation violation7 = new Violation(MovingViolation.DUI, date3);
    Violation violation8 = new Violation(NonMovingViolation.PARKING, date4);
    TrafficViolation trafficViolation3 = new TrafficViolation(violation7, driverName);
    TrafficViolation trafficViolation4 = new TrafficViolation(violation8, driverName);
    Crash crash3 = new Crash(CrashType.BODY_INJURY, date3);
    Crash crash4 = new Crash(CrashType.FENDER_BENDER, date4);
    TrafficCrash trafficCrash3 = new TrafficCrash(crash3, driverName);
    TrafficCrash trafficCrash4 = new TrafficCrash(crash4, driverName);
    VehicleHistory vehicleHistory2 = new VehicleHistory();
    vehicleHistory2.addTrafficViolations(trafficViolation3);
    vehicleHistory2.addTrafficViolations(trafficViolation4);
    vehicleHistory2.addTrafficCrash(trafficCrash3);
    vehicleHistory2.addTrafficCrash(trafficCrash4);

    prospectiveDriver2 = new ProspectiveDriver(driverName, birthDate2, driverLicense2,
        vehicleInfo2, insuranceInfo2, driverHistory2, vehicleHistory2);

    prospectiveDriver3 = new ProspectiveDriver(driver1, birthDate1, driverLicense1,
        vehicleInfo1, insuranceInfo1, driverHistory1, vehicleHistory1);

    registrationValidator2 = new RegistrationValidator(prospectiveDriver2);

    registrationValidator3 = new RegistrationValidator(prospectiveDriver3);
  }

  @Test
  public void testValidateAge() {
    registrationValidator1.validateAge();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateAge();
    assertFalse(registrationValidator2.isValid());
  }

  @Test
  public void testValidateDriverLicense() {
    registrationValidator1.validateDriverLicense();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateDriverLicense();
    assertFalse(registrationValidator2.isValid());
    registrationValidator3.validateDriverLicense();
    assertFalse(registrationValidator3.isValid());
  }

  @Test
  public void testValidateVehicle() {
    registrationValidator1.validateVehicle();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateVehicle();
    assertFalse(registrationValidator2.isValid());
  }

  @Test
  public void testValidateVehicleInsurance() {
    registrationValidator1.validateVehicleInsurance();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateVehicleInsurance();
    assertFalse(registrationValidator2.isValid());
  }

  @Test
  public void testValidateDriverHistory() {
    registrationValidator1.validateDriverHistory();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateDriverHistory();
    assertFalse(registrationValidator2.isValid());
  }

  @Test
  public void testValidateVehicleHistory() {
    registrationValidator1.validateVehicleInsurance();
    assertTrue(registrationValidator1.isValid());
    registrationValidator2.validateVehicleInsurance();
    assertFalse(registrationValidator2.isValid());
  }

}