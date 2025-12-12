package drones;

import drones.model.*;
import java.util.Arrays;

class Main {
  private static final String DIVIDER = "\n########################\n";

  public static void main(String[] args) {
    showcaseDroneClass();
    System.out.println(DIVIDER);
    showcaseRacingDrone();
    System.out.println(DIVIDER);
    showcaseVampireDrone();
  }

  private static void showcaseVampireDrone() {
    var drone = new Drone();
    var drainingDrone = new VampireDrone(false);
    var transformedDrone = new VampireDrone(true);

    transformedDrone.drainEnergy(drone);

    System.out.printf("Generic Drone battery level: %d\n", drone.getBatteryLevel());
    System.out.printf("Vampire Drone battery level: %d\n", drainingDrone.getBatteryLevel());
    drainingDrone.drainEnergy(drone);
    System.out.println("After draining...");
    System.out.printf("Generic Drone battery level: %d\n", drone.getBatteryLevel());
    System.out.printf("Vampire Drone battery level: %d\n", drainingDrone.getBatteryLevel());

    drainingDrone.turnIntoBatDrone();
    drainingDrone.drainEnergy(drone);
  }

  private static void showcaseRacingDrone() {
    var racers =
        new RacingDrone[] {
          new RacingDrone(74.75f), new RacingDrone(50.0f), new RacingDrone(85.5f),
        };
    var winner = RacingDrone.race(racers);
    System.out.println(winner);
    racers[0].setWeight(25.0f);
    racers[0].revEngine();

    var teamRacers =
        new RacingDrone[] {
          new RacingDrone("A", (byte) 2, "Racer", 100.0f, 25.0f, (byte) 100),
          new RacingDrone("B", (byte) 2, "Racer", 100.0f, 35.5f, (byte) 100),
          new RacingDrone("C", (byte) 2, "Racer", 100.0f, 15.0f, (byte) 100),
          new RacingDrone("D", (byte) 3),
          new RacingDrone("E", (byte) 1),
        };
    var sorted = RacingDrone.sortByPosition(teamRacers);
    System.out.println(Arrays.toString(sorted));
  }

  private static void showcaseDroneClass() {
    var drone = new Drone("Prototype", 1.80f, 1.0f, (byte) 50);
    drone.checkFlyParameters();
    drone.revEngine();

    var defaultDrone = new Drone();
    System.out.println(defaultDrone);
    var res = defaultDrone.checkFlyParameters();
    System.out.printf("Are the parameters OK?: %b\n", res);
    defaultDrone.fly(104.0f);
    defaultDrone.fly(96.5f);
  }
}
