package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DriverLicenseTest {

  private DriverLicense driverLicense;

  @Before
  public void setUp() throws Exception {
    Name driverName = new Name("Dharma", "Alpha");
    LocalDate dateOfBirth = LocalDate.of(1995, 5, 10);
    LocalDate insuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate expirationDate = LocalDate.of(2023, 5, 18);
    driverLicense = new DriverLicense("DL3456", driverName, "123 doggie st",
        dateOfBirth, "US", "AL", insuranceDate, expirationDate);
  }

  @Test
  public void testGetLicenseNumber() {
    assertEquals("DL3456", driverLicense.getLicenseNumber());
  }

  @Test
  public void testGetDriverName() {
    Name comparisonName = new Name("Dharma", "Alpha");
    assertEquals(comparisonName, driverLicense.getDriverName());
  }

  @Test
  public void testGetAddress() {
    assertEquals("123 doggie st", driverLicense.getAddress());
  }

  @Test
  public void testGetBirthDate() {
    LocalDate comparisonDate = LocalDate.of(1995, 5, 10);
    assertEquals(comparisonDate, driverLicense.getBirthDate());
  }

  @Test
  public void testGetCountryOfInsurance() {
    assertEquals("US", driverLicense.getCountryOfInsurance());
  }

  @Test
  public void testGetStateOfInsurance() {
    assertEquals("AL", driverLicense.getStateOfInsurance());
  }

  @Test
  public void testGetInsuranceDate() {
    LocalDate comparisonDate = LocalDate.of(2013, 5, 19);
    assertEquals(comparisonDate, driverLicense.getInsuranceDate());
  }

  @Test
  public void testGetExpirationDate() {
    LocalDate comparisonDate = LocalDate.of(2023, 5, 18);
    assertEquals(comparisonDate, driverLicense.getExpirationDate());
  }

  @Test
  public void testEquals1() {
    Name otherDriverName = new Name("Dharma", "Alpha");
    Name otherDriverName2 = new Name("Dharm", "Alpha");
    LocalDate otherDateOfBirth = LocalDate.of(1995, 5, 10);
    LocalDate otherInsuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate otherExpirationDate = LocalDate.of(2023, 5, 18);
    DriverLicense otherDriverLicense1 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense2 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "US", "TX", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense3 = new DriverLicense("D3456", otherDriverName, "123 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense4 = new DriverLicense("DL3456", otherDriverName2,
        "123 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense5 = new DriverLicense("DL3456", otherDriverName, "12 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense6 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherInsuranceDate, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense7 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "Canada", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense8 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "US", "AL", otherDateOfBirth, otherExpirationDate);
    DriverLicense otherDriverLicense9 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherDateOfBirth);

    assertTrue(driverLicense.equals(driverLicense));
    assertTrue(driverLicense.equals(otherDriverLicense1));
    assertFalse(driverLicense.equals(otherDriverName));
    assertFalse(driverLicense.equals(otherDriverLicense2));
    assertFalse(driverLicense.equals(otherDriverLicense3));
    assertFalse(driverLicense.equals(otherDriverLicense4));
    assertFalse(driverLicense.equals(otherDriverLicense5));
    assertFalse(driverLicense.equals(otherDriverLicense6));
    assertFalse(driverLicense.equals(otherDriverLicense7));
    assertFalse(driverLicense.equals(otherDriverLicense8));
    assertFalse(driverLicense.equals(otherDriverLicense9));
  }

  @Test
  public void testHashCode1() {
    Name otherDriverName = new Name("Dharma", "Alpha");
    LocalDate otherDateOfBirth = LocalDate.of(1995, 5, 10);
    LocalDate otherInsuranceDate = LocalDate.of(2013, 5, 19);
    LocalDate otherExpirationDate = LocalDate.of(2023, 5, 18);
    DriverLicense otherDriverLicense = new DriverLicense("DL3456", otherDriverName, "123 doggie st",
        otherDateOfBirth, "US", "AL", otherInsuranceDate, otherExpirationDate);
    DriverLicense otherDriverLicense2 = new DriverLicense("DL3456", otherDriverName,
        "123 doggie st",
        otherDateOfBirth, "US", "TX", otherInsuranceDate, otherExpirationDate);
    assertNotEquals(driverLicense.hashCode(), otherDriverLicense2.hashCode());
    assertEquals(driverLicense.hashCode(), otherDriverLicense.hashCode());
  }
}