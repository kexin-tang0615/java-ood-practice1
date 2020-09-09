package edu.neu.khoury.cs5004.assignment7.problem2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Crash contains information about a crash. This class is used as a part of problem2.
 */
public class Crash {

  private CrashType crashType;
  private LocalDate dateOfCrash;

  /**
   * Constructor that creates a new Crash object, based upon all of the provided input parameters.
   *
   * @param crashType type of crash.
   * @param dateOfCrash date when the crash happened.
   */
  public Crash(CrashType crashType, LocalDate dateOfCrash) {
    this.crashType = crashType;
    this.dateOfCrash = dateOfCrash;
  }

  /**
   * Get type of crash.
   *
   * @return type of crash.
   */
  public CrashType getCrashType() {
    return this.crashType;
  }

  /**
   * Get date when the crash happened.
   *
   * @return date when the crash happened.
   */
  public LocalDate getDateOfCrash() {
    return this.dateOfCrash;
  }

  /**
   * Returns the boolean value whether this equals to the given obj.
   *
   * @return the boolean value whether this equals to the given obj
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Crash)) {
      return false;
    }
    Crash crash = (Crash) object;
    return getCrashType() == crash.getCrashType()
        && Objects.equals(getDateOfCrash(), crash.getDateOfCrash());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getCrashType(), getDateOfCrash());
  }
}
