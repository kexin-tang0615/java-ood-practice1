package edu.neu.khoury.cs5004.assignment7.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class MediaLibrary contains information about a media library. This class is used as a part of
 * problem1.
 */
public class MediaLibrary implements IMediaLibrary {

  private Map<String, AMedia> mediaLibraryMap;

  /**
   * Constructor that creates a new MediaLibrary object, based upon all of the provided input
   * parameters.
   *
   * @param mediaLibraryMap the media library Map
   */
  public MediaLibrary(Map<String, AMedia> mediaLibraryMap) {
    this.mediaLibraryMap = mediaLibraryMap;
  }

  /**
   * Override the findAllMatchedMedia method.
   *
   * @param name director's name
   * @return a List containing AMedia object(s)
   */
  @Override
  public List<AMedia> findAllMatchedMedia(Name name) throws NoSuchNameException {
    int count = 0;
    List<AMedia> mediaList = new ArrayList<>();
    for (AMedia media : this.mediaLibraryMap.values()) {
      if (media.getDirectors().contains(name)) {
        mediaList.add(media);
        count++;
      }
    }
    if (count > 1) {
      mediaList.sort((media1, media2) -> media2.getReleaseYear() - media1.getReleaseYear());
    } else if (count == 0) {
      throw new NoSuchNameException("No such director name existed in the media library!");
    }
    return mediaList;
  }

  /**
   * Override the addMedia method.
   *
   * @param media an AMedia object
   */
  @Override
  public void addMedia(AMedia media) throws AliasExistedException {
    if (this.mediaLibraryMap.containsKey(media.getAlias())) {
      throw new AliasExistedException("The alias has already existed!");
    }
    this.mediaLibraryMap.put(media.getAlias(), media);

  }

  /**
   * Override the streamedRequest method.
   *
   * @param alias the alias as a String
   * @param numOfStreamedRequests the number of streamed requests
   */
  @Override
  public void streamedRequest(String alias, Integer numOfStreamedRequests)
      throws NoSuchAliasException {
    if (!this.mediaLibraryMap.containsKey(alias)) {
      throw new NoSuchAliasException(
          "Can't find the matched alias in the existed media library!");
    }
    AMedia targetMedia = this.mediaLibraryMap.get(alias);
    targetMedia.setStreamedTimesIncrease(numOfStreamedRequests);
  }

  /**
   * Override the streamingStatistics method.
   *
   * @param alias the alias as a String
   * @return an Integer
   */
  @Override
  public Integer streamingStatistics(String alias) throws NoSuchAliasException {
    if (this.mediaLibraryMap.containsKey(alias)) {
      AMedia targetMedia = this.mediaLibraryMap.get(alias);
      return targetMedia.getStreamedTimes();
    }
    throw new NoSuchAliasException(
        "Can't find the matched alias in the existed media library!");
  }

  /**
   * Override the mostStreamedMedia method.
   *
   * @return the most AMedia object
   */
  @Override
  public AMedia mostStreamedMedia() {
    Integer maxStreamedTimes = 0;
    String targetAlias = "";
    for (AMedia media : this.mediaLibraryMap.values()) {
      if (media.getStreamedTimes() > maxStreamedTimes) {
        maxStreamedTimes = media.getStreamedTimes();
        targetAlias = media.getAlias();
      }
    }
    return this.mediaLibraryMap.get(targetAlias);
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
    MediaLibrary that = (MediaLibrary) obj;
    return Objects.equals(mediaLibraryMap, that.mediaLibraryMap);
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(mediaLibraryMap);
  }

  /**
   * Returns the string representation of this object.
   *
   * @return the string representation of this object
   */
  @Override
  public String toString() {
    return "Media Library "
        + this.mediaLibraryMap.toString().replace("=", ": ");
  }
}

