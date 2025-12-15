package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyDrone extends Drone {
  private static final byte DEFAULT_STEALTH_LEVEL = 25;
  private static final byte SINGLE_STEALTH_CHARGE = 5;
  private static final byte MAX_STEALTH_LEVEL = 100;
  private static final byte MIN_STEALTH_LEVEL = 0;
  private static final byte MIN_BATTERY_LEVEL_REQUIRED_FOR_STEALTH_MODE = 30;
  private static final byte DATA_COLLECTION_COST = 5;
  private static final byte REPORT_TRANSMISSION_COST = 25;

  private final List<String> collectedData;
  private byte stealthLevel;
  private boolean isInStealthMode;

  public SpyDrone() {
    super("Spy Drone", DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
    this.collectedData = new ArrayList<>();
    this.stealthLevel = DEFAULT_STEALTH_LEVEL;
    this.isInStealthMode = false;
  }

  public SpyDrone(String name, byte stealthLevel) {
    super(name, DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
    this.collectedData = new ArrayList<>();
    this.stealthLevel = (byte) Math.min(MAX_STEALTH_LEVEL, stealthLevel);
    this.isInStealthMode = false;
  }

  public void toggleStealthMode() {
    if (this.getBatteryLevel() < MIN_BATTERY_LEVEL_REQUIRED_FOR_STEALTH_MODE && !isInStealthMode) {
      System.out.println("Not enough battery for stealth mode!");
      return;
    }

    isInStealthMode = !isInStealthMode;

    if (isInStealthMode) {
      this.setBatteryLevel((byte) (this.getBatteryLevel() - 10));
      System.out.println("Stealth mode ACTIVATED");
    } else {
      System.out.println("Stealth mode DEACTIVATED");
    }
  }

  public void transmitReport() {
    if (collectedData.isEmpty()) {
      System.out.println("No data to transmit!");
      return;
    }

    System.out.println("\n=== REPORT ===");
    System.out.printf("Stealth Level: %d\n", stealthLevel);
    System.out.printf("Data collected: %d entries\n", collectedData.size());
    System.out.println("Data types:");
    System.out.println(Arrays.toString(collectedData.toArray()));

    collectedData.clear();

    this.stealthLevel =
        (byte) Math.max(MIN_STEALTH_LEVEL, this.stealthLevel - REPORT_TRANSMISSION_COST);

    System.out.println("Report transmitted and data wiped.");
  }

  public void collectData(String data) {
    if (!isInStealthMode) {
      System.out.println("Warning: Operating without stealth - high detection risk!");
      return;
    }

    if (data == null) {
      System.out.println("Info: drone detected that data source is empty.");
      return;
    }

    if (this.stealthLevel < DATA_COLLECTION_COST) {
      System.out.println("Insufficient stealth level for data collection!");
      return;
    }

    collectedData.add(data);

    this.stealthLevel =
        (byte) Math.max(MIN_STEALTH_LEVEL, this.stealthLevel - DATA_COLLECTION_COST);

    System.out.printf(
        "Data collected: %s (Total: %d) | Stealth: %d%%\n",
        data, collectedData.size(), this.stealthLevel);
  }

  public void chargeStealthLevel() {
    chargeStealthLevel(this.stealthLevel);
  }

  public int getStealthLevel() {
    return stealthLevel;
  }

  public boolean isInStealthMode() {
    return isInStealthMode;
  }

  @Override
  public String toString() {
    return String.format(
        "%s SPY DRONE INFO: [Collected data size: %d, Stealth level: %d, Stealth mode: %s]",
        super.toString(),
        collectedData.size(),
        stealthLevel,
        isInStealthMode ? "ACTIVE" : "INACTIVE");
  }

  private void chargeStealthLevel(byte currentLevel) {
    if (currentLevel >= MAX_STEALTH_LEVEL) {
      System.out.println("Stealth level fully charged!");
      this.stealthLevel = MAX_STEALTH_LEVEL;
      return;
    }

    var remaining = (byte) (MAX_STEALTH_LEVEL - currentLevel);
    System.out.printf(
        "Charging stealth level... Current: %d%% | Remaining: %d%%\n", currentLevel, remaining);

    var nextLevel = (byte) Math.min(currentLevel + SINGLE_STEALTH_CHARGE, MAX_STEALTH_LEVEL);

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    chargeStealthLevel(nextLevel);
  }
}
