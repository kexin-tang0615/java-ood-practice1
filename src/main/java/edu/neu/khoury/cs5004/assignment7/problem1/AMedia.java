package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;
import java.util.Objects;

/**
 * Abstract class AMedia contains information about a media. This class is used as a part of
 * problem1.
 */
public abstract class AMedia {

  private static final Integer MIN_FOUR_DIGIT_NUM = 1000;
  private static final Integer CURRENT_YEAR = 2019;
  private String alias;
  private String title;
  private Integer releaseYear;
  private List<Name> directors;
  private List<Name> mainActors;
  private Integer streamedTimes;

  /**
   * Constructor that creates a new AMedia object, based upon all of the provided input parameters.
   *
   * @param alias the alias, expressed as a String
   * @param title the title, expressed as a String
   * @param releaseYear the release year, expressed as Integer
   * @param directors the directors, expressed as a List
   * @param mainActors the main actors, expressed as a List
   * @param streamedTimes the streamed times, expressed as Integer
   * @throws InvalidReleaseYearException the invalid release year exception
   */
  public AMedia(String alias, String title, Integer releaseYear, List<Name> directors,
      List<Name> mainActors, Integer streamedTimes) throws InvalidReleaseYearException {
    this.alias = alias;
    this.title = title;
    if (!checkReleaseYear(releaseYear)) {
      throw new InvalidReleaseYearException("Invalid release year!");
    }
    this.releaseYear = releaseYear;
    this.directors = directors;
    this.mainActors = mainActors;
    this.streamedTimes = streamedTimes;
  }

  /**
   * Gets alias as a String.
   *
   * @return the alias
   */
  public String getAlias() {
    return alias;
  }

  /**
   * Gets title as a String.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets release year as an Integer.
   *
   * @return the release year
   */
  public Integer getReleaseYear() {
    return releaseYear;
  }

  /**
   * Gets directors as a List.
   *
   * @return the directors
   */
  public List<Name> getDirectors() {
    return directors;
  }

  /**
   * Gets main actors as a List.
   *
   * @return the main actors
   */
  public List<Name> getMainActors() {
    return mainActors;
  }

  /**
   * Gets streamed times as an Integer.
   *
   * @return the streamed times
   */
  public Integer getStreamedTimes() {
    return streamedTimes;
  }

  /**
   * A helper method to check whether the release year is valid.
   *
   * @param year - an Integer
   * @return a Boolean value
   */
  private Boolean checkReleaseYear(Integer year) {
    if (year >= MIN_FOUR_DIGIT_NUM && year <= CURRENT_YEAR) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }

  /**
   * Increase the number of the streamed times.
   *
   * @param numOfStreamedRequests the number of streamed requests
   */
  protected void setStreamedTimesIncrease(Integer numOfStreamedRequests) {
    this.streamedTimes += numOfStreamedRequests;
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AMedia media = (AMedia) obj;
    return Objects.equals(getAlias(), media.getAlias())
        && Objects.equals(getTitle(), media.getTitle())
        && Objects.equals(getReleaseYear(), media.getReleaseYear())
        && Objects.equals(getDirectors(), media.getDirectors())
        && Objects.equals(getMainActors(), media.getMainActors())
        && Objects.equals(getStreamedTimes(), media.getStreamedTimes());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAlias(), getTitle(), getReleaseYear(), getDirectors(), getMainActors(),
        getStreamedTimes());
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "alias='" + alias + '\''
        + ", title='" + title + '\''
        + ", releaseYear=" + releaseYear
        + ", directors=" + directors
        + ", mainActors=" + mainActors
        + ", streamedTimes=" + streamedTimes
        + '}';
  }
}
