package edu.neu.khoury.cs5004.assignment7.problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Dharma", "Alpha");
  }

  @Test
  public void testGetFirstName() {
    assertEquals("Dharma", name.getFirstName());
  }

  @Test
  public void testGetLastName() {
    assertEquals("Alpha", name.getLastName());
  }

  @Test
  public void testEquals1() {
    Name comparisonName1 = new Name("Dharma", "Alpha");
    Name comparisonName2 = new Name("Dharma", "Beta");
    assertEquals(name, comparisonName1);
    assertNotEquals(name, comparisonName2);
    assertNotEquals(name, 1);
    assertNotEquals(name, "Dharma");
  }
}