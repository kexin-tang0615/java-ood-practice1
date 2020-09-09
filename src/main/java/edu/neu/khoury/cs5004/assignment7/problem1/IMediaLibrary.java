package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.List;

/**
 * The interface Media library.
 */
public interface IMediaLibrary {

  /**
   * Find all matched media list on a given director name.
   *
   * @param name director's name
   * @return the list
   * @throws NoSuchNameException the no such name exception
   */
  List<AMedia> findAllMatchedMedia(Name name) throws NoSuchNameException;

  /**
   * Add a new media to the media library.
   *
   * @param media an AMedia object
   * @throws AliasExistedException the alias existed exception
   */
  void addMedia(AMedia media) throws AliasExistedException;

  /**
   * Increase the number of streamed times.
   *
   * @param alias the alias as a String
   * @param numOfStreamedRequests the number of streamed requests
   * @throws NoSuchAliasException the no such alias exception
   */
  void streamedRequest(String alias, Integer numOfStreamedRequests) throws NoSuchAliasException;

  /**
   * Get streaming statistics as an Integer.
   *
   * @param alias the alias as a String
   * @return the integer
   * @throws NoSuchAliasException the no such alias exception
   */
  Integer streamingStatistics(String alias) throws NoSuchAliasException;

  /**
   * Returns the most streamed media.
   *
   * @return the an AMedia object
   */
  AMedia mostStreamedMedia();

}
