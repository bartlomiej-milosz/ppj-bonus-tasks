package model;

public class VampireDrone extends Drone {
  private static final String DEFAULT_CONSTRUCTOR = "Bram Stoker";

  private final String constructor = DEFAULT_CONSTRUCTOR;
  private boolean isDoneBat = false;
  private boolean isTransformed = false;

  public VampireDrone(boolean isTransformed) {
    super("Vampire Drone", DEFAULT_WEIGHT, DEFAULT_ENGINE_POWER, (byte) 25);
    this.isTransformed = isTransformed;
  }

  public VampireDrone(boolean isDoneBat, boolean isTransformed) {
    this.isDoneBat = isDoneBat;
    this.isTransformed = isTransformed;
  }

  public void drainEnergy(Drone drone) {
    if (!isTransformed) {
      var halfBattery = (byte) (drone.getBatteryLevel() / 2);
      drone.setBatteryLevel((byte) (drone.getBatteryLevel() - halfBattery));
      var total = this.getBatteryLevel() + halfBattery;
      this.setBatteryLevel((byte) Math.min(total, 100));
    } else {
      System.out.println("Vampire is transformed - cannot drain energy!");
    }
  }

  public void turnIntoBatDrone() {
    this.isTransformed = true;
    this.setBatteryLevel((byte) (this.getBatteryLevel() / 2));
    this.setWeight(this.getWeight() / 2);
  }

  @Override
  public String toString() {
    return String.format(
        "%s VAMPIRE DRONE INFO: [constructor: %s, isDoneBat: %b, isTransformed: %b]",
        super.toString(), constructor, isDoneBat, isTransformed);
  }
}
