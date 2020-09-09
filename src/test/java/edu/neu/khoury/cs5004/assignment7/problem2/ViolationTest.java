package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ViolationTest {

  private Violation violation1;
  private Violation violation2;
  private LocalDate violationDate1;
  private LocalDate violationDate2;

  @Before
  public void setUp() throws Exception {
    violationDate1 = LocalDate.of(2017, 03, 12);
    violationDate2 = LocalDate.of(2018, 04, 22);
    violation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    violation2 = new Violation(NonMovingViolation.PAPERWORK, violationDate2);

  }

  @Test
  public void testGetViolationType() {
    assertEquals(MovingViolation.DISTRACTED, violation1.getViolationType());
    assertEquals(NonMovingViolation.PAPERWORK, violation2.getViolationType());
    assertNotEquals(violation1.getViolationType(), violation2.getViolationType());
  }

  @Test
  public void testGetDateOfViolation() {
    LocalDate comparisonDate1 = LocalDate.of(2017, 03, 12);
    LocalDate comparisonDate2 = LocalDate.of(2018, 04, 22);
    assertEquals(comparisonDate1, violation1.getDateOfViolation());
    assertEquals(comparisonDate2, violation2.getDateOfViolation());
    assertNotEquals(comparisonDate1, violation2.getDateOfViolation());
  }

  @Test
  public void testEquals() {
    Violation comparisionViolation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    Violation comparisionViolation2 = new Violation(MovingViolation.DUI, violationDate1);
    Violation comparisionViolation3 = new Violation(MovingViolation.DISTRACTED, violationDate2);
    assertTrue(violation1.equals(violation1));
    assertTrue(violation1.equals(comparisionViolation1));
    assertFalse(violation1.equals(violationDate1));
    assertFalse(violation1.equals(comparisionViolation2));
    assertFalse(violation1.equals(comparisionViolation3));
  }

  @Test
  public void testHashCode() {
    Violation comparisionViolation1 = new Violation(MovingViolation.DISTRACTED, violationDate1);
    assertEquals(violation1.hashCode(), violation1.hashCode());
    assertEquals(violation1.hashCode(), comparisionViolation1.hashCode());
    assertNotEquals(violation1.hashCode(), violation2.hashCode());
  }
}