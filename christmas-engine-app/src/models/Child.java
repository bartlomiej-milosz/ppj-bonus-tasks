package models;

public class Child {
  private Gift receivedGift;
  private boolean isNaughty;

  public Child() {
    this.isNaughty = false;
  }

  public String openGift() {
    var giftContent = this.receivedGift.giftContent();
    System.out.printf("Oh, thank you for: %s\n", giftContent);
    this.receivedGift = null;
    return giftContent;
  }

  public void changeAttitude() {
    this.isNaughty = !this.isNaughty;
  }

  public boolean getIsNaughty() {
    return this.isNaughty;
  }

  public Gift getReceivedGift() {
    return this.receivedGift;
  }

  public void setReceivedGift(Gift gift) {
    this.receivedGift = gift;
  }
}
