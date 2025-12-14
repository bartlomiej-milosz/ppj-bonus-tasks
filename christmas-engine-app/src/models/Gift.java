package models;

public class Gift {
  private String giftContent;
  private float weight;

  public Gift(String giftContent, float weight) {
    this.giftContent = giftContent;
    this.weight = weight;
  }

  public float getWeight() {
    return this.weight;
  }
}