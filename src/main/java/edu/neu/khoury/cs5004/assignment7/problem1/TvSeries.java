package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * Class Movie contains information about a TV series, extending from the AMedia class. This class
 * is used as a part of problem1.
 */
public class TvSeries extends AMedia {

  /**
   * Constructor that creates a new TvSeries object, based upon all of the provided input
   * parameters.
   *
   * @param alias the alias, expressed as a String
   * @param title the title, expressed as a String
   * @param releaseYear the release year, expressed as Integer
   * @param directors the directors, expressed as a List
   * @param mainActors the main actors, expressed as a List
   * @param streamedTimes the streamed times, expressed as Integer
   * @throws InvalidReleaseYearException the invalid release year exception
   */
  public TvSeries(String alias, String title, Integer releaseYear, List<Name> directors,
      List<Name> mainActors, Integer streamedTimes) throws InvalidReleaseYearException {
    super(alias, title, releaseYear, directors, mainActors, streamedTimes);
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "TvSeries {" + super.toString();
  }
}
