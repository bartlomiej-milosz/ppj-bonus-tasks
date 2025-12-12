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
}