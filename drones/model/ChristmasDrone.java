package drones.model;

public class ChristmasDrone extends Drone {
  private Gift gift;

  public ChristmasDrone(Gift gift) {
    this.gift = gift;
  }

  public void deliverGift() {
    var errors = handleDeliveryErrors();
    if (errors.length() > 0) {
      System.out.printf("Failed delivery: %s\n" + errors.trim());
      return;
    }
    System.out.printf("Delivery completed: %s\n", gift);
    this.gift = null;
  }

  private String handleDeliveryErrors() {
    var errors = new StringBuilder();
    if (gift == null) {
      errors.append("Gift is empty. ");
    }
    if (gift != null && !gift.getIsReadyToBeDelivered()) {
      errors.append("Gift is not ready. ");
    }
    if (gift != null) {
      boolean isEnginePowerSufficient = this.getWeight() + gift.getWeight() < this.getEnginePower();
      if (!isEnginePowerSufficient) {
        errors.append("Engine too weak. ");
      }
    }
    return errors.toString();
  }
}
