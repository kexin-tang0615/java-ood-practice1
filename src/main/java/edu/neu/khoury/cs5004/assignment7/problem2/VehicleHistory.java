package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class VehicleHistory contains information about all crashes and all traffic violations committed
 * with the prospective vehicle, including the date of violation, a type of violation, and the name
 * of the offending driver.
 */
public class VehicleHistory {

  public static class TrafficViolation {

    private Violation violation;
    private Name driver;

    /**
     * Constructor that creates a new VehicleHistory object, based upon all of the provided input
     * parameters.
     *
     * @param violation the violation.
     * @param driver the driver who had the violation.
     */
    public TrafficViolation(Violation violation, Name driver) {
      this.violation = violation;
      this.driver = driver;
    }

    /**
     * Get the violation.
     *
     * @return the violation.
     */
    public Violation getViolation() {
      return violation;
    }

    /**
     * Get the driver who had the violation.
     *
     * @return the driver who had the violation.
     */
    public Name getDriver() {
      return driver;
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (!(object instanceof TrafficViolation)) {
        return false;
      }
      TrafficViolation that = (TrafficViolation) object;
      return Objects.equals(getViolation(), that.getViolation())
          && Objects.equals(getDriver(), that.getDriver());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getViolation(), getDriver());
    }
  }

  /**
   * Class for a crash happen in traffic.
   */
  public static class TrafficCrash {

    private Crash crash;
    private Name driver;

    /**
     * Constructor.
     *
     * @param crash the crash happened.
     * @param driver the driver who had the crash.
     */
    public TrafficCrash(Crash crash, Name driver) {
      this.crash = crash;
      this.driver = driver;
    }

    /**
     * Get the crash.
     *
     * @return crash.
     */
    public Crash getCrash() {
      return crash;
    }

    /**
     * Get the driver who had the crash.
     *
     * @return the driver who had the crash.
     */
    public Name getDriver() {
      return driver;
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (!(object instanceof TrafficCrash)) {
        return false;
      }
      TrafficCrash that = (TrafficCrash) object;
      return Objects.equals(getCrash(), that.getCrash())
          && Objects.equals(getDriver(), that.getDriver());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getCrash(), getDriver());
    }
  }

  private Set<TrafficViolation> trafficViolations;
  private Set<TrafficCrash> trafficCrashes;

  /**
   * Constructor. Create an empty vehicle history.
   */
  public VehicleHistory() {
    this.trafficViolations = new HashSet<TrafficViolation>();
    this.trafficCrashes = new HashSet<TrafficCrash>();
  }

  /**
   * Add a traffic violation to the history.
   *
   * @param trafficViolation an object of traffic violation.
   */
  public void addTrafficViolations(TrafficViolation trafficViolation) {
    this.trafficViolations.add(trafficViolation);
  }

  /**
   * Add a crash happened in traffic.
   *
   * @param trafficCrash an object of traffic crash.
   */
  public void addTrafficCrash(TrafficCrash trafficCrash) {
    this.trafficCrashes.add(trafficCrash);
  }

  /**
   * Get the set of traffic violations associated with the vehicle.
   *
   * @return set of traffic violations associated with the vehicle.
   */
  public Set<TrafficViolation> getTrafficViolations() {
    return this.trafficViolations;
  }

  /**
   * Get the set of traffic crashes associated with the vehicle.
   *
   * @return set of traffic crashes associated with the vehicle.
   */
  public Set<TrafficCrash> getTrafficCrashes() {
    return this.trafficCrashes;
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
    if (!(object instanceof VehicleHistory)) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) object;
    return Objects.equals(getTrafficViolations(), that.getTrafficViolations())
        && Objects.equals(getTrafficCrashes(), that.getTrafficCrashes());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getTrafficViolations(), getTrafficCrashes());
  }
}
