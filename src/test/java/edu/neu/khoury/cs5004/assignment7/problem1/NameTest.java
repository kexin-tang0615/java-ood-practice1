package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name name;
  private Name nameWithNoMiddle;

  @Before
  public void setUp() throws Exception {
    name = new Name("Ann", "John", "Wilson");
    nameWithNoMiddle = new Name("Jay", "Smith");
  }

  @Test
  public void getFirstName() {
    assertEquals("Ann", name.getFirstName());
  }

  @Test
  public void getMiddleName() {
    assertEquals("John", name.getMiddleName());
  }

  @Test
  public void getLastName() {
    assertEquals("Smith", nameWithNoMiddle.getLastName());
  }

  @Test
  public void equals() {
    assertTrue(name.equals(name));
  }

  @Test
  public void equals2() {
    assertFalse(name.equals(nameWithNoMiddle));
  }

  @Test
  public void equals3() {
    assertFalse(name.equals("a"));
  }

  @Test
  public void equals4() {
    Name name3 = new Name("Jay", "King");
    assertFalse(nameWithNoMiddle.equals(name3));
  }

  @Test
  public void equals5() {
    Name name4 = new Name("Ann", "John", "Wilson");
    assertTrue(name.equals(name4));
  }

  @Test
  public void equals6() {
    assertFalse(name.equals(null));
  }

  @Test
  public void equals7() {
    Name name5 = new Name("Ann", "Snow", "Wilson");
    assertFalse(name.equals(name5));
  }

  @Test
  public void hashCode1() {
    assertFalse(name.hashCode() == nameWithNoMiddle.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals("Name{firstName='Ann', middleName='John', lastName='Wilson'}", name.toString());
  }

}