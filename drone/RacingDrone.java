package drone;

class RacingDrone extends Drone {
  private static final String DEFAULT_RACING_TEAM = "unknown";
  private static final byte DEFAULT_POSITION = 0;

  private String racingTeam;
  private byte positionInRanking;

  RacingDrone() {
    this(DEFAULT_RACING_TEAM, DEFAULT_POSITION);
  }

  RacingDrone(String racingTeam, byte positionInRanking) {
    super();
    this.racingTeam = racingTeam;
    this.positionInRanking = positionInRanking;
  }

  RacingDrone(float enginePower) {
    super(DEFAULT_NAME, DEFAULT_WEIGHT, enginePower, DEFAULT_BATTERY_LEVEL);
    this.racingTeam = DEFAULT_RACING_TEAM;
    this.positionInRanking = DEFAULT_POSITION;
  }

  RacingDrone(
      String racingTeam,
      byte positionInRanking,
      String name,
      float weight,
      float enginePower,
      byte batteryLevel) {
    super(name, weight, enginePower, batteryLevel);
    this.racingTeam = racingTeam;
    this.positionInRanking = positionInRanking;
  }

  static Drone race(Drone[] racers) {
    if (racers == null || racers.length == 0) {
      throw new IllegalArgumentException("No racers provided");
    }
    var winner = racers[0];
    for (var racer : racers) {
      if (racer.getEnginePower() > winner.getEnginePower()) winner = racer;
    }
    return winner;
  }

  static RacingDrone[] sortByPosition(RacingDrone[] racers) {
    for (int i = 0; i < racers.length - 1; i++) {
      for (int j = 0; j < racers.length - 1 - i; j++) {
        boolean shouldSwap = false;
        if (racers[j].positionInRanking > racers[j + 1].positionInRanking) {
          shouldSwap = true;
        } else if (racers[j].positionInRanking == racers[j + 1].positionInRanking) {
          if (racers[j].getEnginePower() < racers[j + 1].getEnginePower()) {
            shouldSwap = true;
          }
        }

        if (shouldSwap) {
          var temp = racers[j];
          racers[j] = racers[j + 1];
          racers[j + 1] = temp;
        }
      }
    }
    return racers;
  }

  public byte getPositionInRanking() {
    return this.positionInRanking;
  }

  @Override
  void revEngine() {
    super.revEngine();
    for (var i = 0; i < super.getEnginePower() / super.getWeight(); i++) {
      System.out.println("ZOOOOOM");
    }
  }

  @Override
  public String toString() {
    return String.format(
        "%s RACING DRONE INFO: [team: %s, position: %d]",
        super.toString(), racingTeam, positionInRanking);
  }
}
