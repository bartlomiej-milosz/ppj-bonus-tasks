package models;

import service.ChristmasEngine;

public class Santa {
  private static final int REINDEER_TEAM_NUMBER = 9;

  private ChristmasEngine christmasEngine;
  private Reindeer[] reindeerTeam = new Reindeer[REINDEER_TEAM_NUMBER];

  public Santa(ChristmasEngine christmasEngine, Reindeer[] reindeerTeam) {
    if (reindeerTeam.length > REINDEER_TEAM_NUMBER)
      throw new IllegalArgumentException(
          String.format("Santa Claus cannot have more than %d reindeer.", REINDEER_TEAM_NUMBER));
    this.christmasEngine = christmasEngine;
    this.reindeerTeam = reindeerTeam;
  }

  public void giveGift(Child c) {
    if (c.getIsNaughty()) {
      System.out.println("The child was naughty and will not receive a gift.");
    } else {
      c.setReceivedGift(dropGift());
      c.openGift();
    }
  }

  public void fly() {
    var message =
        isAllReindeersHealthy() && reindeerTeam.length == REINDEER_TEAM_NUMBER
            ? "Let's go!"
            : "I'm afraid I can't do that";
    System.out.println(message);
  }

  public Gift dropGift() {
    var giftList = this.christmasEngine.getGiftList();
    if (giftList.isEmpty()) throw new IllegalStateException("Cannot drop gift from empty list.");
    return giftList.removeFirst();
  }

  public ChristmasEngine getChristmasEngine() {
    return this.christmasEngine;
  }

  private boolean isAllReindeersHealthy() {
    for (var reindeer : this.reindeerTeam) {
      if (!reindeer.isHealthy()) return false;
    }
    return true;
  }
}
