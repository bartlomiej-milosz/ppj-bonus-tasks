package service;

import java.util.ArrayList;
import java.util.List;
import models.Gift;

/*
  -showName() - prints out name of the factory
	-countGifts() - returns int amount of all created gifts using this Class
	-createGift(String giftContent,weight) - adds gift to array of gifts in ChristmassEngine
	-createGift() - adds gift to array of gifts in ChristmasEngine. Name of the gift is randomly choosen from: [Car,Doll,Ball] and random weight between 1 and 10.
	-createGift(String giftContent) - adds gift (with default wieight =5) to array of gifts in ChristmasEngine
	-createGifts(String[] names, int[] weights) - adds multiple gifts to array of gifts in ChristmasEngine
	-countAverageWeight() - returns average weight of gifts.
*/
public class ChristmasEngine {
  private static final String DEFAULT_FACTORY_NAME = "Default Factory";

  private static int giftCounter = 0;

  private String factoryName = DEFAULT_FACTORY_NAME;
  private List<Gift> giftList = new ArrayList<>();

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
    final int MIN_WEIGHT = 1;
    final int MAX_WEIGHT = 10;
    var randomGiftList = new String[] {"Car", "Doll", "Ball"};
    var randomGiftIndex = (int) (Math.random() * (randomGiftList.length));
    var randomWeight = (float) (Math.random() * (MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT);
    this.createGift(randomGiftList[randomGiftIndex], randomWeight);
  }

  public void createGift(String giftContent, float weight) {
    this.giftList.add(new Gift(giftContent, weight));
    increaseGiftCounter();
  }

  private void increaseGiftCounter() {
    giftCounter++;
  }
}
