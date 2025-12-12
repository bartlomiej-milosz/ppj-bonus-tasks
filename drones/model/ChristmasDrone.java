package drones.model;

public class ChristmasDrone extends Drone {
  private Gift gift;

  public ChristmasDrone() {}

  public ChristmasDrone(Gift gift) {
    this.gift = gift;
  }

  public void deliverGift() {
    var errors = handleDeliveryErrors();
    if (errors.length() > 0) {
      System.out.printf("Failed delivery: %s\n", errors.trim());
      return;
    }
    System.out.printf("Delivery completed: %s\n", gift);
    this.gift = null;
  }

  public void setGift(Gift gift) {
    this.gift = gift;
  }

  private String handleDeliveryErrors() {
    var errors = new StringBuilder();
    if (gift == null) {
      errors.append("Gift is empty. ");
    }
    if (!gift.getIsReadyToBeDelivered()) {
      errors.append("Gift is not ready. ");
    }
    boolean isOverweight = this.getWeight() + gift.getWeight() > this.getEnginePower();
    if (isOverweight) {
      errors.append("Engine too weak. ");
    }
    return errors.toString();
  }
}
