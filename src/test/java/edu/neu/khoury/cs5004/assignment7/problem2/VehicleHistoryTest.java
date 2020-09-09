package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficCrash;
import edu.neu.khoury.cs5004.assignment7.problem2.VehicleHistory.TrafficViolation;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class VehicleHistoryTest {

  private VehicleHistory vehicleHistory;
  private VehicleHistory.TrafficViolation trafficViolation1;
  private VehicleHistory.TrafficViolation trafficViolation2;
  private Violation violation1;
  private Violation violation2;
  private VehicleHistory.TrafficCrash trafficCrash1;
  private VehicleHistory.TrafficCrash trafficCrash2;
  private Crash crash1;
  private Crash crash2;
  private LocalDate date1;
  private LocalDate date2;
  private Name name;

  @Before
  public void setUp() throws Exception {
    date1 = LocalDate.of(2012, 11, 12);
    date2 = LocalDate.of(2018, 2, 23);
    name = new Name("Dharma", "Alpha");

    violation1 = new Violation(MovingViolation.DUI, date1);
    violation2 = new Violation(NonMovingViolation.PARKING, date2);
    trafficViolation1 = new TrafficViolation(violation1, name);
    trafficViolation2 = new TrafficViolation(violation2, name);

    crash1 = new Crash(CrashType.BODY_INJURY, date2);
    crash2 = new Crash(CrashType.FENDER_BENDER, date1);
    trafficCrash1 = new TrafficCrash(crash1, name);
    trafficCrash2 = new TrafficCrash(crash2, name);

    vehicleHistory = new VehicleHistory();
    vehicleHistory.addTrafficViolations(trafficViolation1);
    vehicleHistory.addTrafficViolations(trafficViolation2);
    vehicleHistory.addTrafficCrash(trafficCrash1);
    vehicleHistory.addTrafficCrash(trafficCrash2);
  }

  @Test
  public void testAddAndGetTrafficViolations() {
    Set<TrafficViolation> comTrafficViolations = new HashSet<TrafficViolation>();
    comTrafficViolations.add(trafficViolation1);
    comTrafficViolations.add(trafficViolation2);
    assertEquals(comTrafficViolations, vehicleHistory.getTrafficViolations());
  }

  @Test
  public void testAddAndGetTrafficCrashes() {
    Set<TrafficCrash> compTrafficCrashes = new HashSet<TrafficCrash>();
    compTrafficCrashes.add(trafficCrash1);
    compTrafficCrashes.add(trafficCrash2);
    assertEquals(compTrafficCrashes, vehicleHistory.getTrafficCrashes());
  }

  @Test
  public void testEqualsVehicleHistory() {

    VehicleHistory vehicleHistory1 = new VehicleHistory();
    vehicleHistory1.addTrafficViolations(trafficViolation1);
    vehicleHistory1.addTrafficCrash(trafficCrash1);
    vehicleHistory1.addTrafficCrash(trafficCrash2);

    VehicleHistory vehicleHistory2 = new VehicleHistory();
    vehicleHistory2.addTrafficViolations(trafficViolation1);
    vehicleHistory2.addTrafficViolations(trafficViolation2);
    vehicleHistory2.addTrafficCrash(trafficCrash2);

    VehicleHistory vehicleHistory3 = new VehicleHistory();
    vehicleHistory3.addTrafficViolations(trafficViolation1);
    vehicleHistory3.addTrafficViolations(trafficViolation2);
    vehicleHistory3.addTrafficCrash(trafficCrash1);
    vehicleHistory3.addTrafficCrash(trafficCrash2);

    assertTrue(vehicleHistory.equals(vehicleHistory));
    assertTrue(vehicleHistory.equals(vehicleHistory3));
    assertFalse(vehicleHistory.equals(vehicleHistory1));
    assertFalse(vehicleHistory.equals(vehicleHistory2));
  }

  @Test
  public void testHashCodeVehicleHistory() {
    VehicleHistory vehicleHistory1 = new VehicleHistory();
    vehicleHistory1.addTrafficViolations(trafficViolation1);
    vehicleHistory1.addTrafficCrash(trafficCrash1);
    vehicleHistory1.addTrafficCrash(trafficCrash2);

    VehicleHistory vehicleHistory3 = new VehicleHistory();
    vehicleHistory3.addTrafficViolations(trafficViolation1);
    vehicleHistory3.addTrafficViolations(trafficViolation2);
    vehicleHistory3.addTrafficCrash(trafficCrash1);
    vehicleHistory3.addTrafficCrash(trafficCrash2);

    assertEquals(vehicleHistory.hashCode(), vehicleHistory.hashCode());
    assertNotEquals(vehicleHistory.hashCode(), vehicleHistory1.hashCode());
    assertEquals(vehicleHistory.hashCode(), vehicleHistory3.hashCode());
  }

  @Test
  public void testeEqualsTrafficViolation() {
    TrafficViolation comparsionTrafficViolation = new TrafficViolation(violation1, name);
    assertTrue(trafficViolation1.equals(trafficViolation1));
    assertTrue(trafficViolation1.equals(comparsionTrafficViolation));
    assertFalse(trafficViolation1.equals(name));
    assertFalse(trafficViolation1.equals(trafficViolation2));
  }

  @Test
  public void testHashCodeTrafficViolation() {
    TrafficViolation comparsionTrafficViolation = new TrafficViolation(violation1, name);
    assertEquals(trafficViolation1.hashCode(), trafficViolation1.hashCode());
    assertEquals(trafficViolation1.hashCode(), comparsionTrafficViolation.hashCode());
    assertNotEquals(trafficViolation1.hashCode(), trafficViolation2.hashCode());


  }

  @Test
  public void testEqualsTrafficCrash() {
    TrafficCrash comparsionTrafficCrash = new TrafficCrash(crash1, name);
    assertTrue(trafficCrash1.equals(trafficCrash1));
    assertTrue(trafficCrash1.equals(comparsionTrafficCrash));
    assertFalse(trafficCrash1.equals(name));
    assertFalse(trafficCrash1.equals(trafficCrash2));
  }

  @Test
  public void testHashCodeTrafficCrash() {
    TrafficCrash comparsionTrafficCrash = new TrafficCrash(crash1, name);
    assertEquals(trafficCrash1.hashCode(), trafficCrash1.hashCode());
    assertEquals(trafficCrash1.hashCode(), comparsionTrafficCrash.hashCode());
    assertNotEquals(trafficCrash1.hashCode(), trafficCrash2.hashCode());
  }
}