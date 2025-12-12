package drones.service;

import drones.model.Drone;
import java.util.ArrayList;
import java.util.List;

/* i used streams for variety */
public class DroneControlRoom {
  private static final byte CHARGE_AMOUNT = 20;

  private List<Drone> drones = new ArrayList<>();
  private float windPowerOutside;

  public DroneControlRoom() {}

  public DroneControlRoom(List<Drone> drones) {
    this.drones = drones;
  }

  public Drone findMostPowerful() {
    if (drones.isEmpty()) {
      throw new IllegalStateException("No drones available");
    }
    return findMostPowerfulRecursive(0, drones.get(0));
  }

  public int countDronesThatCanFly() {
    if (drones.isEmpty()) {
      throw new IllegalStateException("No drones available");
    }
    return (int) drones.stream().filter(drone -> drone.canItFly()).count();
  }

  public List<Drone> sortAllDrones() {
    if (drones.isEmpty()) {
      throw new IllegalStateException("No drones available");
    }
    return drones.stream()
        .sorted((d1, d2) -> Float.compare(d1.getWeight(), d2.getWeight()))
        .toList();
  }

  public void chargeAllDrones() {
    if (drones.isEmpty()) {
      throw new IllegalStateException("No drones available");
    }
    drones.forEach(drone -> drone.chargeDrone((byte) CHARGE_AMOUNT));
  }

  public void addNewDrone(Drone drone) {
    if (drone == null) {
      throw new IllegalArgumentException("Drone cannot be null");
    }
    drones.add(drone);
  }

  public void setDrones(List<Drone> drones) {
    this.drones = drones;
  }

  @Override
  public String toString() {
    return String.format(
        "DRONE CONTROL ROOM INFO: [Drones: %s, Wind power outside: %.2f]",
        drones.toString(), windPowerOutside);
  }

  private Drone findMostPowerfulRecursive(int index, Drone currentMax) {
    if (index >= drones.size()) {
      return currentMax;
    }
    var current = drones.get(index);
    var newMax = current.getEnginePower() > currentMax.getEnginePower() ? current : currentMax;
    return findMostPowerfulRecursive(index + 1, newMax);
  }
}
