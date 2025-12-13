package models;

import utils.Utils;

public class Drone {
  protected static final String DEFAULT_NAME = "Generic Drone";
  protected static final float DEFAULT_WEIGHT = 1.8f;
  protected static final float DEFAULT_ENGINE_POWER = 150.0f;
  protected static final byte DEFAULT_BATTERY_LEVEL = 100;

  private int uniqueId;
  private String name;
  private float weight; // in kg
  private float enginePower; // in kW
  private byte batteryLevel; // in %

  public Drone() {
    this(DEFAULT_NAME, DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
  }

  public Drone(String name) {
    this(name, DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
  }

  public Drone(String name, float weight, float enginePower, byte batteryLevel) {
    validateObjectCreation(batteryLevel, weight, enginePower);
    this.uniqueId = Utils.generateId();
    this.name = name;
    this.weight = weight;
    this.enginePower = enginePower;
    this.batteryLevel = batteryLevel;
  }

  public boolean checkFlyParameters() {
    var isParametersCorrect = enginePower > weight && batteryLevel > 0;
    if (isParametersCorrect) {
      System.out.println("System parameters OK.");
    } else {
      var message =
          enginePower < weight
              ? "Weigth of this drone is too large for this engine"
              : batteryLevel < 0
                  ? "Drone is out of power. Please charge it"
                  : "Everything looks good.";
      System.out.println(message);
    }
    return isParametersCorrect;
  }

  public void fly(float distance) {
    if (distance > batteryLevel) {
      System.out.println("Insufficient battery for this flight!");
      return;
    }
    batteryLevel -= distance;
    System.out.printf("Flying... Battery: %d%%\n", batteryLevel);
  }

  public void revEngine() {
    for (var i = 0; i < enginePower / weight; i++) {
      System.out.println("Vroom!");
    }
  }

  public void chargeDrone(byte batteryLevel) {
    this.batteryLevel = (byte) Math.min(100, this.batteryLevel + batteryLevel);
  }

  public boolean canItFly() {
    return enginePower > weight && batteryLevel > 0;
  }

  public float getWeight() {
    return this.weight;
  }

  public float getEnginePower() {
    return this.enginePower;
  }

  public byte getBatteryLevel() {
    return this.batteryLevel;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public void setBatteryLevel(byte batteryLevel) {
    this.batteryLevel = batteryLevel;
  }

  @Override
  public String toString() {
    return String.format(
        "GENERAL INFO: [ID: %d, Name: %s, Weight: %.2f, Engine Power: %.2f, Battery Level: %d%%]",
        uniqueId, name, weight, enginePower, batteryLevel);
  }

  private void validateObjectCreation(byte batteryLevel, float weight, float enginePower) {
    if (weight <= 0) {
      throw new IllegalArgumentException("Weight must be positive");
    }
    if (enginePower <= 0) {
      throw new IllegalArgumentException("Engine power must be positive");
    }
    if (batteryLevel < 0 || batteryLevel > 100) {
      throw new IllegalArgumentException("Battery must be 0-100");
    }
  }
}
