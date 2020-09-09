package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficCrash;
import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficViolation;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class AcceptedDriversTest {

  private AcceptedDrivers acceptedDrivers;
  private ProspectiveDriver prospectiveDriver1;
  private ProspectiveDriver prospectiveDriver2;

  @Before
  public void setUp() throws Exception {
    Name driverName = new Name("Dharma", "Alpha");

    LocalDate birthDate = LocalDate.of(1995, 10, 14);

    LocalDate insuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate expirationDate = LocalDate.of(2023, 5, 18);
    DriverLicense driverLicense1 = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate, "US", "AL", insuranceDate, expirationDate);
    DriverLicense driverLicense2 = new DriverLicense("DL3456", driverName, "123 doggie st",
        birthDate, "Canada", "AL", insuranceDate, expirationDate);

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

    prospectiveDriver1 = new ProspectiveDriver(driverName, birthDate, driverLicense1,
        vehicleInfo, insuranceInfo, driverHistory, vehicleHistory);
    prospectiveDriver2 = new ProspectiveDriver(driverName, birthDate, driverLicense2,
        vehicleInfo, insuranceInfo, driverHistory, vehicleHistory);

    acceptedDrivers = new AcceptedDrivers();
  }

  @Test
  public void testAddDriver() {
    Set<ProspectiveDriver> comparisonSet = new HashSet<>();
    comparisonSet.add(prospectiveDriver1);
    assertEquals(comparisonSet, acceptedDrivers.addDriver(prospectiveDriver1));
    assertEquals(comparisonSet, acceptedDrivers.addDriver(prospectiveDriver2));
  }

}