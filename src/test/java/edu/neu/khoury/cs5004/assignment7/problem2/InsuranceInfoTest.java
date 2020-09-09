package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class InsuranceInfoTest {

  private InsuranceInfo insuranceInfo;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Dharma", "Alpha");
    Name driver1 = new Name("Ben", "Ben");
    Name driver2 = new Name("Kumo", "Ooki");
    Set<Name> otherdrivers = new HashSet<>();
    otherdrivers.add(driver1);
    otherdrivers.add(driver2);
    LocalDate expirationDate = LocalDate.of(2020, 11, 12);
    insuranceInfo = new InsuranceInfo(name, otherdrivers, expirationDate);
  }

  @Test
  public void testGetOfficialOwner() {
    Name comparisonName = new Name("Dharma", "Alpha");
    assertEquals(comparisonName, insuranceInfo.getOfficialOwner());
  }

  @Test
  public void testGetOtherDriver() {
    Name comparisonDriver1 = new Name("Ben", "Ben");
    Name comparisonDriver2 = new Name("Kumo", "Ooki");
    Set<Name> comparisonOtherdrivers = new HashSet<>();
    comparisonOtherdrivers.add(comparisonDriver1);
    comparisonOtherdrivers.add(comparisonDriver2);
    assertEquals(comparisonOtherdrivers, insuranceInfo.getOtherDriver());
  }

  @Test
  public void testGetExpirationDate() {
    LocalDate comExpirationDate = LocalDate.of(2020, 11, 12);
    assertEquals(comExpirationDate, insuranceInfo.getExpirationDate());
  }

  @Test
  public void testEquals1() {
    Name name1 = new Name("Dharma", "Alpha");
    Name driver3 = new Name("Ben", "Ben");
    Name driver4 = new Name("Kumo", "Ooki");
    Set<Name> otherdrivers1 = new HashSet<>();
    otherdrivers1.add(driver3);
    otherdrivers1.add(driver4);
    Set<Name> otherdrivers2 = new HashSet<>();
    LocalDate expirationDate1 = LocalDate.of(2020, 11, 12);
    InsuranceInfo insuranceInfo1 = new InsuranceInfo(name1, otherdrivers1, expirationDate1);
    LocalDate expirationDate2 = LocalDate.of(2010, 11, 12);
    InsuranceInfo insuranceInfo2 = new InsuranceInfo(driver3, otherdrivers1, expirationDate1);
    InsuranceInfo insuranceInfo3 = new InsuranceInfo(name1, otherdrivers2, expirationDate1);
    InsuranceInfo insuranceInfo4 = new InsuranceInfo(name1, otherdrivers2, expirationDate2);
    assertTrue(insuranceInfo.equals(insuranceInfo));
    assertTrue(insuranceInfo.equals(insuranceInfo1));
    assertFalse(insuranceInfo.equals(insuranceInfo2));
    assertFalse(insuranceInfo.equals(insuranceInfo3));
    assertFalse(insuranceInfo.equals(insuranceInfo4));
  }

  @Test
  public void testHashCode1() {
    Name name1 = new Name("Dharma", "Alpha");
    Name driver3 = new Name("Ben", "Ben");
    Name driver4 = new Name("Kumo", "Ooki");
    Set<Name> otherdrivers1 = new HashSet<>();
    otherdrivers1.add(driver3);
    otherdrivers1.add(driver4);
    LocalDate expirationDate1 = LocalDate.of(2020, 11, 12);
    InsuranceInfo insuranceInfo1 = new InsuranceInfo(name1, otherdrivers1, expirationDate1);
    InsuranceInfo insuranceInfo2 = new InsuranceInfo(driver3, otherdrivers1, expirationDate1);

    assertEquals(insuranceInfo.hashCode(), insuranceInfo.hashCode());
    assertEquals(insuranceInfo.hashCode(), insuranceInfo1.hashCode());
    assertNotEquals(insuranceInfo.hashCode(), insuranceInfo2.hashCode());
  }
}