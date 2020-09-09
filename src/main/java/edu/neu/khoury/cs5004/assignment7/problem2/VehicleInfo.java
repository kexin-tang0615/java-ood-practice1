package edu.neu.khoury.cs5004.assignment7.problem2;

import java.util.Objects;

/**
 * Class VehicleInfo contains information about make, model and year of the vehicle, as well as
 * about the vehicle’s official owner.
 */
public class VehicleInfo {

  private String make;
  private String model;
  private Integer year;
  private Name owner;

  /**
   * Constructor that creates a new VehicleInfo object, based upon all of the provided input
   * parameters.
   *
   * @param make the make of the vehicle.
   * @param model the model of the vehicle.
   * @param year the year when the vehicle was made.
   * @param owner the owner of the vehicle.
   */
  public VehicleInfo(String make, String model, Integer year,
      Name owner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.owner = owner;
  }

  /**
   * Get the make of the vehicle.
   *
   * @return the make of the vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * Get the model of the vehicle.
   *
   * @return the the model of the vehicle.
   */
  public String getModel() {
    return model;
  }

  /**
   * Get the year when the vehicle was made.
   *
   * @return the year when the vehicle was made.
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Get the owner of the vehicle.
   *
   * @return the owner of the vehicle.
   */
  public Name getOwner() {
    return owner;
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
    if (!(object instanceof VehicleInfo)) {
      return false;
    }
    VehicleInfo that = (VehicleInfo) object;
    return Objects.equals(getMake(), that.getMake())
        && Objects.equals(getModel(), that.getModel())
        && Objects.equals(getYear(), that.getYear())
        && Objects.equals(getOwner(), that.getOwner());
  }

  /**
   * Returns hashCode of this object.
   *
   * @return hashCode of this object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMake(), getModel(), getYear(), getOwner());
  }
}
