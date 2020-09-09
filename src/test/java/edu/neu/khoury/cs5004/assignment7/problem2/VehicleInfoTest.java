package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleInfoTest {

  private VehicleInfo vehicleInfo;
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Dharma", "Alpha");
    vehicleInfo = new VehicleInfo("Toyota", "Camery", 2011, name);
  }

  @Test
  public void testGetMake() {
    assertEquals("Toyota", vehicleInfo.getMake());
  }

  @Test
  public void testGetModel() {
    assertEquals("Camery", vehicleInfo.getModel());
  }

  @Test
  public void testGetYear() {
    assertEquals(Integer.valueOf(2011), vehicleInfo.getYear());
  }

  @Test
  public void testGetOwner() {
    Name comparsionName = new Name("Dharma", "Alpha");
    assertEquals(comparsionName, vehicleInfo.getOwner());
  }

  @Test
  public void testEquals1() {
    Name name1 = new Name("Dharm", "Alpha");
    VehicleInfo vehicleInfo1 = new VehicleInfo("Toyota", "Camery", 2011, name);
    VehicleInfo vehicleInfo2 = new VehicleInfo("Tyota", "Camery", 2011, name);
    VehicleInfo vehicleInfo3 = new VehicleInfo("Toyota", "Camry", 2011, name);
    VehicleInfo vehicleInfo4 = new VehicleInfo("Toyota", "Camery", 2001, name);
    VehicleInfo vehicleInfo5 = new VehicleInfo("Toyota", "Camery", 2011, name1);
    assertTrue(vehicleInfo.equals(vehicleInfo));
    assertTrue(vehicleInfo.equals(vehicleInfo1));
    assertFalse(vehicleInfo.equals(vehicleInfo2));
    assertFalse(vehicleInfo.equals(vehicleInfo3));
    assertFalse(vehicleInfo.equals(vehicleInfo4));
    assertFalse(vehicleInfo.equals(vehicleInfo5));
  }

  @Test
  public void testHashCode1() {
    Name name1 = new Name("Dharm", "Alpha");
    VehicleInfo vehicleInfo1 = new VehicleInfo("Toyota", "Camery", 2011, name);
    VehicleInfo vehicleInfo2 = new VehicleInfo("Tyota", "Camery", 2011, name);
    assertEquals(vehicleInfo.hashCode(), vehicleInfo1.hashCode());
    assertNotEquals(vehicleInfo.hashCode(), vehicleInfo2.hashCode());
  }

}