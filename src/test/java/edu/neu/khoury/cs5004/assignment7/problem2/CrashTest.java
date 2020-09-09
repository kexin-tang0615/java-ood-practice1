package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class CrashTest {

  private Crash crash;

  @Before
  public void setUp() throws Exception {
    LocalDate crashDate = LocalDate.of(2018, 12, 22);
    crash = new Crash(CrashType.FENDER_BENDER, crashDate);
  }

  @Test
  public void testGetCrashType() {
    assertEquals(CrashType.FENDER_BENDER, crash.getCrashType());
  }

  @Test
  public void testGetDateOfCrash() {
    LocalDate comparisonDate = LocalDate.of(2018, 12, 22);
    assertEquals(comparisonDate, crash.getDateOfCrash());
  }

  @Test
  public void testEquals() {
    LocalDate otherCrashDate = LocalDate.of(2018, 12, 22);
    LocalDate otherCrashDate1 = LocalDate.of(2019, 12, 22);
    Crash otherCrash = new Crash(CrashType.FENDER_BENDER, otherCrashDate);
    Crash otherCrash1 = new Crash(CrashType.BODY_INJURY, otherCrashDate);
    Crash otherCrash2 = new Crash(CrashType.FENDER_BENDER, otherCrashDate1);
    assertTrue(crash.equals(crash));
    assertTrue(crash.equals(otherCrash));
    assertFalse(crash.equals(1));
    assertFalse(crash.equals(otherCrash1));
    assertFalse(crash.equals(otherCrash2));
  }

}