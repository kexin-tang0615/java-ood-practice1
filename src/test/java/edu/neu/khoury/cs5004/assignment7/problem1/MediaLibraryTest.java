package edu.neu.khoury.cs5004.assignment7.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {

  private Name directorName1;
  private Name TvDirectorName1;
  private List<Name> movieDirectorNameList1;
  private List<Name> movieActorList1;
  private AMedia movie2;
  private AMedia tvSeries1;
  private Map<String, AMedia> mediaLibraryMap;
  private MediaLibrary mediaLibrary;
  private MediaLibrary mediaLibrary2;

  @Before
  public void setUp() throws Exception {
    directorName1 = new Name("Ann", "Jay", "Tim");
    movieDirectorNameList1 = new ArrayList<>();
    movieDirectorNameList1.add(directorName1);

    Name MovieActor1 = new Name("Betty", "Lee");
    Name MovieActor2 = new Name("Diana", "John", "Smith");
    movieActorList1 = new ArrayList<>();
    movieActorList1.add(MovieActor1);
    movieActorList1.add(MovieActor2);
    AMedia movie1 = new Movie("K", "Toy", 2012, movieDirectorNameList1, movieActorList1, 124000);
    movie2 = new Movie("Y", "The Lion", 2015, movieDirectorNameList1, movieActorList1, 124000);

    TvDirectorName1 = new Name("Tom", "Brady");
    Name TvDirectorName2 = new Name("Jim", "Canyon", "King");
    List<Name> tvDirectorNameList1 = new ArrayList<>();
    tvDirectorNameList1.add(TvDirectorName1);
    tvDirectorNameList1.add(TvDirectorName2);

    Name tvActor1 = new Name("Bell", "Young");
    Name tvActor2 = new Name("Alfred", "Smith");
    Name tvActor3 = new Name("David", "John", "Wilson");
    List<Name> tvActorList1 = new ArrayList<>();
    tvActorList1.add(tvActor1);
    tvActorList1.add(tvActor2);
    tvActorList1.add(tvActor3);

    tvSeries1 = new TvSeries("A", "ABC", 2016, tvDirectorNameList1, tvActorList1, 8000);

    mediaLibraryMap = new HashMap<>();
    mediaLibraryMap.put("K", movie1);
    mediaLibraryMap.put("A", tvSeries1);
    mediaLibraryMap.put("Y", movie2);

    Map<String, AMedia> mediaLibraryMap2 = new HashMap<>();
    mediaLibraryMap2.put("K", movie1);
    mediaLibraryMap2.put("Y", movie2);

    mediaLibrary = new MediaLibrary(mediaLibraryMap);
    mediaLibrary2 = new MediaLibrary(mediaLibraryMap2);

  }

  @Test(expected = NoSuchNameException.class)
  public void findAllMatchedMediaException() throws Exception {
    Name name = new Name("a", "b", "c");
    List<AMedia> invalid = this.mediaLibrary.findAllMatchedMedia(name);
  }

  @Test
  public void findAllMatchedMedia() throws Exception {
    List<AMedia> list1 = mediaLibrary.findAllMatchedMedia(directorName1);
    assertEquals((Integer) 2015, list1.get(0).getReleaseYear());
  }

  @Test
  public void findAllMatchedMedia2() throws Exception {
    List<AMedia> list2 = mediaLibrary.findAllMatchedMedia(TvDirectorName1);
    assertTrue(list2.get(0) == tvSeries1 && list2.size() == 1);
  }

  @Test(expected = AliasExistedException.class)
  public void addMediaException() throws Exception {
    AMedia newMovie = new Movie("K", "Story2", 2016, movieDirectorNameList1, movieActorList1,
        200000);
    this.mediaLibrary.addMedia(newMovie);
  }

  @Test
  public void addMedia() throws Exception {
    AMedia newTvSeries = new TvSeries("Crown", "Game of Thrones", 2018, movieDirectorNameList1,
        movieActorList1, 10000000);
    this.mediaLibrary.addMedia(newTvSeries);
    assertTrue(this.mediaLibraryMap.get("Crown").equals(newTvSeries));
  }

  @Test(expected = NoSuchAliasException.class)
  public void streamedRequestException() throws Exception {
    this.mediaLibrary.streamedRequest("Kyy", 12234);
  }

  @Test
  public void streamedRequest() throws Exception {
    this.mediaLibrary.streamedRequest("A", 12000);
    assertTrue(this.mediaLibraryMap.get("A").getStreamedTimes().equals(20000));
  }

  @Test(expected = NoSuchAliasException.class)
  public void streamingStatisticsException() throws Exception {
    this.mediaLibrary.streamingStatistics("Kiwi");
  }

  @Test
  public void streamingStatistics() throws Exception {
    assertTrue(this.mediaLibrary.streamingStatistics("K").equals(124000));
  }

  @Test
  public void mostStreamedMedia() {
    assertTrue(this.mediaLibrary.mostStreamedMedia().equals(movie2));
  }

  @Test
  public void equals() {
    assertTrue(mediaLibrary.equals(mediaLibrary));
  }

  @Test
  public void equals2() {
    assertFalse(mediaLibrary.equals("a"));
  }

  @Test
  public void equals3() {
    assertFalse(mediaLibrary.equals(null));
  }

  @Test
  public void equals4() {
    assertFalse(mediaLibrary.equals(mediaLibrary2));
  }

  @Test
  public void hashCode1() {
    assertFalse(mediaLibrary.hashCode() == mediaLibrary2.hashCode());
  }

  @Test
  public void toString1() {
    assertEquals(
        "Media Library {A: TvSeries {alias: 'A', title: 'ABC', "
            + "releaseYear: 2016, directors: [Name{firstName: 'Tom', middleName: 'null', "
            + "lastName: 'Brady'}, Name{firstName: 'Jim', middleName: 'Canyon', lastName: 'King'}], "
            + "mainActors: [Name{firstName: 'Bell', middleName: 'null', lastName: 'Young'}, "
            + "Name{firstName: 'Alfred', middleName: 'null', lastName: 'Smith'}, "
            + "Name{firstName: 'David', middleName: 'John', lastName: 'Wilson'}], "
            + "streamedTimes: 8000}, Y: Movie {alias: 'Y', title: 'The Lion', "
            + "releaseYear: 2015, directors: [Name{firstName: 'Ann', "
            + "middleName: 'Jay', lastName: 'Tim'}], "
            + "mainActors: [Name{firstName: 'Betty', middleName: 'null', lastName: 'Lee'}, "
            + "Name{firstName: 'Diana', middleName: 'John', lastName: 'Smith'}], streamedTimes: 124000}, "
            + "K: Movie {alias: 'K', title: 'Toy', releaseYear: 2012, "
            + "directors: [Name{firstName: 'Ann', middleName: 'Jay', lastName: 'Tim'}], "
            + "mainActors: [Name{firstName: 'Betty', middleName: 'null', lastName: 'Lee'}, "
            + "Name{firstName: 'Diana', middleName: 'John', lastName: 'Smith'}], streamedTimes: 124000}}",
        this.mediaLibrary.toString());
  }

}