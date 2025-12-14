package service;

import java.util.ArrayList;
import java.util.List;
import models.Gift;

public class ChristmasEngine {
  private static final String DEFAULT_FACTORY_NAME = "Default Factory";
  private static final float DEFAULT_WEIGHT = 5.0f;

  private static int giftCounter = 0;

  private String factoryName;
  private List<Gift> giftList = new ArrayList<>();

  public ChristmasEngine(List<Gift> giftList) {
    this(DEFAULT_FACTORY_NAME, giftList);
  }

  public ChristmasEngine(String factoryName, List<Gift> giftList) {
    if (!giftList.isEmpty()) giftCounter += giftList.size();
    this.factoryName = factoryName;
    this.giftList = new ArrayList<>(giftList);
  }

  public void showName() {
    System.out.println(this.factoryName);
  }

  public int countGifts() {
    return giftCounter;
  }

  public void createGift() {
    final var MIN_WEIGHT = 1;
    final var MAX_WEIGHT = 10;
    var randomGiftList = new String[] {"Car", "Doll", "Ball"};
    var randomGiftIndex = (int) (Math.random() * (randomGiftList.length));
    var randomWeight = (float) (Math.random() * (MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT);
    this.createGift(randomGiftList[randomGiftIndex], randomWeight);
  }

  public void createGift(String giftContent) {
    this.createGift(giftContent, DEFAULT_WEIGHT);
  }

  public void createGift(String giftContent, float weight) {
    this.giftList.add(new Gift(giftContent, weight));
    increaseGiftCounter();
  }

  public void createGifts(String[] giftNames, float[] giftWeights) {
    if (giftNames.length != giftWeights.length) {
      throw new IllegalArgumentException("Arrays must have same length");
    }
    for (var i = 0; i < giftNames.length; i++) {
      this.createGift(giftNames[i], giftWeights[i]);
    }
  }

  public List<Gift> getGiftList() {
    return this.giftList;
  }

  public float countAverageWeight() {
    if (giftList.isEmpty()) return 0.0f;
    var sum = 0.0f;
    for (var gift : this.giftList) {
      sum += gift.weight();
    }
    return sum / giftList.size();
  }

  private void increaseGiftCounter() {
    giftCounter++;
  }
}
