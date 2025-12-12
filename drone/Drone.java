package drone;

class Drone {
  private static final String DEFAULT_NAME = "Javanator";
  private static final float DEFAULT_WEIGHT = 1.8f;
  private static final float DEFAULT_ENGINE_POWER = 150.0f;
  private static final byte DEFAULT_BATTERY_LEVEL = 100;

  private int uniqueId;
  private String name;
  private float weight; // in kg
  private float enginePower; // in kW
  private byte batteryLevel; // in %

  Drone() {
    this(DEFAULT_NAME, DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
  }

  Drone(String name) {
    this(name, DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, DEFAULT_BATTERY_LEVEL);
  }

  Drone(String name, float weight, float enginePower, byte batteryLevel) {
    validateObjectCreation(batteryLevel, weight, enginePower);
    this.uniqueId = Utils.generateId();
    this.name = name;
    this.weight = weight;
    this.enginePower = enginePower;
    this.batteryLevel = batteryLevel;
  }

  boolean checkFlyParameters() {
    return enginePower > weight && batteryLevel > 0;
  }

  void fly(float distance) {
    if (distance > batteryLevel) {
      System.out.println("Insufficient battery for this flight!");
      return;
    }
    batteryLevel -= distance;
    System.out.printf("Flying... Battery: %d%%\n", batteryLevel);
  }

  void revEngine() {
    for (var i = 0; i < enginePower / weight; i++) {
      System.out.println("Vroom!");
    }
  }

  @Override
  public String toString() {
    return String.format(
        "[ID: %d, Name: %s, Weight: %.2f, Engine Power: %.2f, Battery Level: %d%%]",
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

class Main {
  public static void main(String[] args) {
    var drone = new Drone("Mosianator");
    System.out.println(drone);
    drone.fly(105.0f);
    drone.fly(97.5f);
    drone.revEngine();
  }
}
