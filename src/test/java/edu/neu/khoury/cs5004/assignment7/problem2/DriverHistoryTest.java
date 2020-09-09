package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class DriverHistoryTest {

  private DriverHistory driverHistory;
  private Violation violation1;
  private Violation violation2;
  private LocalDate violationDate1;
  private LocalDate violationDate2;

  @Before
  public void setUp() throws Exception {
    violationDate1 = LocalDate.of(2018, 12, 12);
    violationDate2 = LocalDate.of(2019, 3, 13);
    violation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    violation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    driverHistory = new DriverHistory();
  }

  @Test
  public void testAddAndGetViolation() {
    Violation comparisonViolation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation comparisonViolation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    Set<Violation> comparisonViolations = new HashSet<Violation>();
    comparisonViolations.add(comparisonViolation1);
    comparisonViolations.add(comparisonViolation2);
    driverHistory.addViolation(violation1);
    driverHistory.addViolation(violation2);
    assertEquals(comparisonViolations, driverHistory.getViolations());
  }

  @Test
  public void testEquals1() {
    Violation comparisonViolation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation comparisonViolation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    DriverHistory comparsionDriverHistory = new DriverHistory();
    comparsionDriverHistory.addViolation(comparisonViolation1);
    comparsionDriverHistory.addViolation(comparisonViolation2);
    assertFalse(driverHistory.equals(1));
    assertFalse(driverHistory.equals(comparsionDriverHistory));
    assertTrue(driverHistory.equals(driverHistory));
    driverHistory.addViolation(violation1);
    driverHistory.addViolation(violation2);
    assertTrue(driverHistory.equals(comparsionDriverHistory));
  }

  @Test
  public void testHashCode1() {
    Violation comparisonViolation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation comparisonViolation2 = new Violation(NonMovingViolation.PARKING, violationDate2);
    DriverHistory comparsionDriverHistory = new DriverHistory();
    comparsionDriverHistory.addViolation(comparisonViolation1);
    comparsionDriverHistory.addViolation(comparisonViolation2);
    assertEquals(driverHistory.hashCode(), driverHistory.hashCode());
    assertNotEquals(driverHistory.hashCode(), comparisonViolation2.hashCode());
    driverHistory.addViolation(violation1);
    driverHistory.addViolation(violation2);
    assertEquals(driverHistory, comparsionDriverHistory);
  }
}