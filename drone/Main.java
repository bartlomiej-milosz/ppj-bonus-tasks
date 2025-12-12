package drone;

class Main {
  public static void main(String[] args) {
    showcaseDroneClass();
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
