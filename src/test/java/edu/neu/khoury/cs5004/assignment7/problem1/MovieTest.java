package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

  private Movie movie;
  private AMedia movie2;
  private List<Name> directorNameList;
  private List<Name> mainActorList;
  private List<Name> directorNameList2;
  private List<Name> mainActorList2;

  @Before
  public void setUp() throws Exception {
    Name directorName1 = new Name("Ann", "Jay", "Tim");
    Name directorName2 = new Name("Ron", "William");
    Name directorName3 = new Name("Edison", "Ben", "Abbey");
    directorNameList = new ArrayList<>();
    directorNameList.add(directorName1);
    directorNameList.add(directorName2);
    directorNameList.add(directorName3);

    Name mainActor1 = new Name("Betty", "Lee");
    Name mainActor2 = new Name("Elly", "English");
    Name mainActor3 = new Name("Diana", "John", "Smith");
    mainActorList = new ArrayList<>();
    mainActorList.add(mainActor1);
    mainActorList.add(mainActor2);
    mainActorList.add(mainActor3);
    movie = new Movie("K", "The Souvenir", 2018, directorNameList, mainActorList, 24000);

    directorNameList2 = new ArrayList<>();
    directorNameList2.add(directorName2);

    mainActorList2 = new ArrayList<>();
    mainActorList2.add(mainActor2);

    movie2 = new Movie("R", "Cat", 2016, directorNameList2, mainActorList, 15000);

  }

  @Test(expected = InvalidReleaseYearException.class)
  public void invalidYear() throws Exception {
    Movie invalidMovie = new Movie("R", "yy", 2025, directorNameList, mainActorList, 3000);
  }

  @Test(expected = InvalidReleaseYearException.class)
  public void invalidYear2() throws Exception {
    Movie invalidMovie2 = new Movie("R", "yy", 800, directorNameList, mainActorList, 3000);
  }

  @Test
  public void getAlias() {
    assertTrue(movie.getAlias().equals("K"));

  }

  @Test
  public void getTitle() {
    assertTrue(movie.getTitle().equals("The Souvenir"));
  }

  @Test
  public void getReleaseYear() {
    assertTrue(movie.getReleaseYear().equals(2018));
  }

  @Test
  public void getDirectors() {
    assertTrue(movie.getDirectors().equals(directorNameList));
  }

  @Test
  public void getMainActors() {
    assertTrue(movie.getMainActors().equals(mainActorList));
  }

  @Test
  public void getStreamedTimes() {
    assertTrue(movie.getStreamedTimes().equals(24000));
  }

  @Test
  public void setStreamedTimesIncrease() {
    movie.setStreamedTimesIncrease(8000);
    assertEquals((Integer) 32000, movie.getStreamedTimes());
  }

  @Test
  public void equals() {
    assertTrue(movie.equals(movie));
  }

  @Test
  public void equals2() {
    assertFalse(movie.equals(2));
  }


  @Test
  public void equals3() throws Exception {
    AMedia movie3 = new Movie("K", "The Souvenir", 2018, directorNameList, mainActorList, 24000);
    assertTrue(movie.equals(movie3));
  }

  @Test
  public void equals4() {
    assertFalse(movie.equals(null));
  }

  @Test
  public void equals5() throws Exception {
    AMedia movie4 = new Movie("TT", "The Souvenir", 2018, directorNameList, mainActorList, 24000);
    assertFalse(movie.equals(movie4));
  }

  @Test
  public void equals6() throws Exception {
    AMedia movie5 = new Movie("K", "Toy", 2018, directorNameList, mainActorList, 24000);
    assertFalse(movie.equals(movie5));
  }

  @Test
  public void equals7() throws Exception {
    AMedia movie6 = new Movie("K", "The Souvenir", 2017, directorNameList, mainActorList, 24000);
    assertFalse(movie.equals(movie6));
  }

  @Test
  public void equals8() throws Exception {
    AMedia movie7 = new Movie("K", "The Souvenir", 2018, directorNameList2, mainActorList, 24000);
    assertFalse(movie.equals(movie7));
  }

  @Test
  public void equals9() throws Exception {
    AMedia movie8 = new Movie("K", "The Souvenir", 2018, directorNameList, mainActorList2, 24000);
    assertFalse(movie.equals(movie8));
  }

  @Test
  public void equals10() throws Exception {
    AMedia movie9 = new Movie("K", "The Souvenir", 2018, directorNameList, mainActorList, 74000);
    assertFalse(movie.equals(movie9));
  }

  @Test
  public void hashCode1() {
    assertFalse(movie.hashCode() == movie2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "Movie {alias='K', title='The Souvenir', releaseYear=2018, "
            + "directors=[Name{firstName='Ann', middleName='Jay', lastName='Tim'}, "
            + "Name{firstName='Ron', middleName='null', lastName='William'}, "
            + "Name{firstName='Edison', middleName='Ben', lastName='Abbey'}], "
            + "mainActors=[Name{firstName='Betty', middleName='null', lastName='Lee'}, "
            + "Name{firstName='Elly', middleName='null', lastName='English'}, Name{firstName='Diana', "
            + "middleName='John', lastName='Smith'}], streamedTimes=24000}",
        movie.toString());
  }

}