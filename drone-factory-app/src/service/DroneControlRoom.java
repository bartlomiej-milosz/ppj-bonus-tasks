package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Drone;

/* i used streams for variety */
public class DroneControlRoom {
  private static final byte CHARGE_AMOUNT = 20;

  private List<Drone> drones = new ArrayList<>();
  private float windPowerOutside;

  public DroneControlRoom() {}

  public DroneControlRoom(List<Drone> drones) {
    this.drones = new ArrayList<>(drones);
  }

  public Drone findMostPowerful() {
    validateNotEmpty();
    return findMostPowerfulRecursive(0, drones.get(0));
  }

  public int countDronesThatCanFly() {
    validateNotEmpty();
    return (int) drones.stream().filter(Drone::canItFly).count();
  }

  public List<Drone> sortAllDrones() {
    validateNotEmpty();
    return drones.stream()
        .sorted(Comparator.comparing(Drone::getWeight))
        .toList();
  }

  public void chargeAllDrones() {
    validateNotEmpty();
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

  public List<Drone> getDrones() {
    return this.drones;
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

  private void validateNotEmpty() {
    if (drones.isEmpty()) {
      throw new IllegalStateException("No drones available");
    }
  }
}
