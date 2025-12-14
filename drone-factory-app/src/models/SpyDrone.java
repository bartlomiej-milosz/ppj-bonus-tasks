package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyDrone extends Drone {
  private static final byte DEFAULT_STEALTH_LEVEL = 5;
  private static final byte MAX_STEALTH_LEVEL = 100;
  private static final byte MIN_BATTERY_LEVEL_REQUIRED_FOR_STEALTH_MODE = 30;
  private static final byte DATA_COLLECTION_COST_IN_STEALTH_MODE = 25;

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
    /* Toggle stealth mode */
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
    this.stealthLevel -= DATA_COLLECTION_COST_IN_STEALTH_MODE;
    System.out.println("Report transmitted and data wiped.");
  }

  public void collecteData(String data) {
    if (!isInStealthMode) {
      System.out.println("Warning: Operating without stealth - high detection risk!");
    }
    if (data == null) {
      System.out.println("Info: drone detected that data source is empty.");
      return;
    }
    collectedData.add(data);
    System.out.printf("Data collected: %s (Total: %d)\n", data, collectedData.size());
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
}
