package drone;

import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    // showcaseDroneClass();
    showcaseRacingDrone();
  }

  private static void showcaseRacingDrone() {
    var racers =
        new RacingDrone[] {
          new RacingDrone(74.75f), new RacingDrone(50.0f), new RacingDrone(85.5f),
        };
    var winner = RacingDrone.race(racers);
    System.out.println(winner);
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
    System.out.println(res);
    defaultDrone.fly(104.0f);
    defaultDrone.fly(96.5f);
  }
}
