package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficCrash;
import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficViolation;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class ProspectiveDriverTest {

  private ProspectiveDriver prospectiveDriver;
  private Name driverName;
  private LocalDate birthDate;

  @Before
  public void setUp() throws Exception {
    driverName = new Name("Dharma", "Alpha");

    birthDate = LocalDate.of(1995, 10, 14);

    LocalDate insuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate expirationDate = LocalDate.of(2023, 5, 18);
    DriverLicense driverLicense = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate, "US", "AL", insuranceDate, expirationDate);

    VehicleInfo vehicleInfo = new VehicleInfo("Toyota", "Camery", 2011, driverName);

    Name driver1 = new Name("Ben", "Ben");
    Name driver2 = new Name("Kumo", "Ooki");
    Set<Name> otherDrivers = new HashSet<>();
    otherDrivers.add(driver1);
    otherDrivers.add(driver2);
    LocalDate insuranceExpirationDate = LocalDate.of(2020, 11, 12);
    InsuranceInfo insuranceInfo = new InsuranceInfo(driverName, otherDrivers,
        insuranceExpirationDate);

    LocalDate violationDate1 = LocalDate.of(2018, 12, 12);
    LocalDate violationDate2 = LocalDate.of(2019, 3, 13);
    Violation violation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation violation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    DriverHistory driverHistory = new DriverHistory();
    driverHistory.addViolation(violation1);
    driverHistory.addViolation(violation2);

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
    VehicleHistory vehicleHistory = new VehicleHistory();
    vehicleHistory.addTrafficViolations(trafficViolation1);
    vehicleHistory.addTrafficViolations(trafficViolation2);
    vehicleHistory.addTrafficCrash(trafficCrash1);
    vehicleHistory.addTrafficCrash(trafficCrash2);

    prospectiveDriver = new ProspectiveDriver(driverName, birthDate, driverLicense,
        vehicleInfo, insuranceInfo, driverHistory, vehicleHistory);
  }

  @Test
  public void testGetDriverName() {
    Name comparisonDriverName = new Name("Dharma", "Alpha");
    assertEquals(comparisonDriverName, prospectiveDriver.getDriverName());
  }

  @Test
  public void testGetBirthDate() {
    LocalDate comparisonBirthDate = LocalDate.of(1995, 10, 14);
    assertEquals(comparisonBirthDate, prospectiveDriver.getBirthDate());
  }

  @Test
  public void testGetDriverLicense() {
    LocalDate comInsuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate comExpirationDate = LocalDate.of(2023, 5, 18);
    DriverLicense comDriverLicense = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate, "US", "AL", comInsuranceDate, comExpirationDate);
    assertEquals(comDriverLicense, prospectiveDriver.getDriverLicense());
  }

  @Test
  public void testGetVehicleInfo() {
    VehicleInfo comVehicleInfo = new VehicleInfo("Toyota", "Camery", 2011, driverName);
    assertEquals(comVehicleInfo, prospectiveDriver.getVehicleInfo());
  }

  @Test
  public void testGetInsuranceInfo() {
    Name comDriver1 = new Name("Ben", "Ben");
    Name comDriver2 = new Name("Kumo", "Ooki");
    Set<Name> comOtherDrivers = new HashSet<>();
    comOtherDrivers.add(comDriver1);
    comOtherDrivers.add(comDriver2);
    LocalDate comInsuranceExpirationDate = LocalDate.of(2020, 11, 12);
    InsuranceInfo comInsuranceInfo = new InsuranceInfo(driverName, comOtherDrivers,
        comInsuranceExpirationDate);
    assertEquals(comInsuranceInfo, prospectiveDriver.getInsuranceInfo());
  }

  @Test
  public void testGetDriverHistroy() {
    LocalDate comViolationDate1 = LocalDate.of(2018, 12, 12);
    LocalDate comViolationDate2 = LocalDate.of(2019, 3, 13);
    Violation comViolation1 = new Violation(MovingViolation.DISTRACTED, comViolationDate1);
    Violation comViolation2 = new Violation(NonMovingViolation.PARKING, comViolationDate2);
    DriverHistory driverHistory = new DriverHistory();
    driverHistory.addViolation(comViolation1);
    driverHistory.addViolation(comViolation2);
    assertEquals(driverHistory, prospectiveDriver.getDriverHistory());
  }

  @Test
  public void testGetVehicleHistory() {
    LocalDate comDate1 = LocalDate.of(2012, 11, 12);
    LocalDate comDate2 = LocalDate.of(2018, 2, 23);
    Violation comViolation3 = new Violation(MovingViolation.DUI, comDate1);
    Violation comViolation4 = new Violation(NonMovingViolation.PARKING, comDate2);
    TrafficViolation comTrafficViolation1 = new TrafficViolation(comViolation3, driverName);
    TrafficViolation comTrafficViolation2 = new TrafficViolation(comViolation4, driverName);
    Crash comCrash1 = new Crash(CrashType.BODY_INJURY, comDate2);
    Crash comCrash2 = new Crash(CrashType.FENDER_BENDER, comDate1);
    TrafficCrash comTrafficCrash1 = new TrafficCrash(comCrash1, driverName);
    TrafficCrash comTrafficCrash2 = new TrafficCrash(comCrash2, driverName);
    VehicleHistory comVehicleHistory = new VehicleHistory();
    comVehicleHistory.addTrafficViolations(comTrafficViolation1);
    comVehicleHistory.addTrafficViolations(comTrafficViolation2);
    comVehicleHistory.addTrafficCrash(comTrafficCrash1);
    comVehicleHistory.addTrafficCrash(comTrafficCrash2);
    VehicleHistory vh = prospectiveDriver.getVehicleHistory();
    assertEquals(comVehicleHistory, prospectiveDriver.getVehicleHistory());
  }
}