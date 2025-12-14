import java.util.ArrayList;
import java.util.List;
import models.Gift;
import service.ChristmasEngine;

class Main {
  public static void main(String[] args) {
    var giftList =
        new ArrayList<>(List.of(new Gift("A", 1.25f), new Gift("B", 1.25f), new Gift("C", 1.25f)));
    var engine = new ChristmasEngine(giftList);
    System.out.println(engine.countGifts());
    
    giftList.add(new Gift("D", 1.5f));
    engine = new ChristmasEngine(giftList);
    System.out.println(engine.countGifts());
  }
}
