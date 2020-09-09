package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TvSeriesTest {

  private TvSeries tvSeries;
  private AMedia tvSeries2;
  private List<Name> directorNameList;
  private List<Name> mainActorList;

  @Before
  public void setUp() throws Exception {
    Name directorName1 = new Name("Tom", "Brady");
    Name directorName2 = new Name("Jim", "Canyon", "King");
    directorNameList = new ArrayList<>();
    directorNameList.add(directorName1);
    directorNameList.add(directorName2);

    Name mainActor1 = new Name("Bell", "Young");
    Name mainActor2 = new Name("Alfred", "Smith");
    Name mainActor3 = new Name("David", "John", "Wilson");
    mainActorList = new ArrayList<>();
    mainActorList.add(mainActor1);
    mainActorList.add(mainActor2);
    mainActorList.add(mainActor3);
    tvSeries = new TvSeries("A", "ABC", 2016, directorNameList, mainActorList, 8000);

    tvSeries2 = new TvSeries("RE", "The Lion", 2019, directorNameList, directorNameList, 40000);

  }

  @Test(expected = InvalidReleaseYearException.class)
  public void invalidYear() throws Exception {
    AMedia invalidTv = new TvSeries("R", "yy", 2025, directorNameList, mainActorList, 3000);
  }

  @Test(expected = InvalidReleaseYearException.class)
  public void invalidYear2() throws Exception {
    TvSeries invalidTv2 = new TvSeries("R", "yy", 978, directorNameList, mainActorList, 3000);
  }

  @Test
  public void getAlias() {
    assertTrue(tvSeries.getAlias().equals("A"));
  }

  @Test
  public void getTitle() {
    assertTrue(tvSeries.getTitle().equals("ABC"));
  }

  @Test
  public void getReleaseYear() {
    assertTrue(tvSeries.getReleaseYear().equals(2016));
  }

  @Test
  public void getDirectors() {
    assertTrue(tvSeries.getDirectors().equals(directorNameList));
  }

  @Test
  public void getMainActors() {
    assertTrue(tvSeries.getMainActors().equals(mainActorList));
  }

  @Test
  public void getStreamedTimes() {
    assertTrue(tvSeries.getStreamedTimes().equals(8000));
  }

  @Test
  public void mediaIncrease() {
    tvSeries.setStreamedTimesIncrease(2000);
    assertEquals((Integer) 10000, tvSeries.getStreamedTimes());
  }

  @Test
  public void equals() {
    assertTrue(tvSeries.equals(tvSeries));
  }

  @Test
  public void equals2() {
    assertFalse(tvSeries.equals("t"));
  }

  @Test
  public void hashCode1() {
    assertFalse(tvSeries.hashCode() == tvSeries2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "TvSeries {alias='A', title='ABC', releaseYear=2016, "
            + "directors=[Name{firstName='Tom', middleName='null', lastName='Brady'}, "
            + "Name{firstName='Jim', middleName='Canyon', lastName='King'}], "
            + "mainActors=[Name{firstName='Bell', middleName='null', lastName='Young'}, "
            + "Name{firstName='Alfred', middleName='null', lastName='Smith'}, "
            + "Name{firstName='David', middleName='John', lastName='Wilson'}], streamedTimes=8000}",
        tvSeries.toString());
  }

}