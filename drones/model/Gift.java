package drones.model;

public class Gift {
  private String nameOfContent;
  private float weight;
  private boolean isReadyToBeDelivered;

  public Gift(String nameOfContent, float weight) {
    this(nameOfContent, weight, true);
  }

  public Gift(String nameOfContent, float weight, boolean isReadyToBeDelivered) {
    this.nameOfContent = nameOfContent;
    this.weight = weight;
    this.isReadyToBeDelivered = isReadyToBeDelivered;
  }

  public void prepare() {
    this.isReadyToBeDelivered = true;
  }

  public void unpack() {
    this.isReadyToBeDelivered = false;
    System.out.printf("Gift contents: ", nameOfContent);
  }

  public float getWeight() {
    return this.weight;
  }

  public boolean getIsReadyToBeDelivered() {
    return this.isReadyToBeDelivered;
  }

  public void setIsReadyToBeDelivered(boolean isReadyToBeDelivered) {
    this.isReadyToBeDelivered = isReadyToBeDelivered;
  }

  @Override
  public String toString() {
    return String.format(
        "GIFT INFO: [Content: %s, Weight: %.2f, Ready to be delivered: %b]",
        nameOfContent, weight, isReadyToBeDelivered);
  }
}
