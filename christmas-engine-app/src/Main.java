import java.util.ArrayList;
import java.util.List;
import models.*;
import service.*;

class Main {
  private static final String DIVIDER = "\n########################\n";

  public static void main(String[] args) {
    showcaseChristmasEngine();
    System.out.println(DIVIDER);
    showcaseSanta();
    System.out.println(DIVIDER);
    showcaseChild();
    System.out.println(DIVIDER);
    showcaseCompleteChristmasScenario();
  }

  private static void showcaseChristmasEngine() {
    System.out.println("=== ChristmasEngine Showcase ===");

    var engine1 = new ChristmasEngine(new ArrayList<>());
    engine1.showName();

    var initialGifts = List.of(new Gift("Teddy Bear", 2.5f), new Gift("LEGO Set", 3.2f));
    var engine2 = new ChristmasEngine("North Pole Factory", initialGifts);
    engine2.showName();
    System.out.printf("Initial gift count: %d\n", engine2.countGifts());

    engine2.createGift();
    engine2.createGift("PlayStation 5");
    engine2.createGift("Bike", 15.5f);

    System.out.printf("Total gifts created globally: %d\n", engine2.countGifts());
    System.out.printf("Gifts in this factory: %d\n", engine2.getGiftList().size());

    var names = new String[] {"Book", "Puzzle", "Board Game"};
    var weights = new float[] {0.5f, 1.2f, 2.0f};
    engine2.createGifts(names, weights);

    System.out.printf("After bulk creation - total gifts: %d\n", engine2.countGifts());
    System.out.printf("Average weight: %.2f kg\n", engine2.countAverageWeight());

    System.out.println("\nAll gifts in factory:");
    engine2
        .getGiftList()
        .forEach(
            gift -> System.out.printf("  - %s (%.1f kg)\n", gift.giftContent(), gift.weight()));
  }

  private static void showcaseSanta() {
    System.out.println("=== Santa Showcase ===");

    var engine = new ChristmasEngine("Santa's Workshop", new ArrayList<>());
    engine.createGift("Robot", 3.0f);
    engine.createGift("Doll", 1.5f);
    engine.createGift("Train Set", 4.5f);

    var healthyReindeer =
        new Reindeer[] {
          new Reindeer("Dasher", true),
          new Reindeer("Dancer", true),
          new Reindeer("Prancer", true),
          new Reindeer("Vixen", true),
          new Reindeer("Comet", true),
          new Reindeer("Cupid", true),
          new Reindeer("Donner", true),
          new Reindeer("Blitzen", true),
          new Reindeer("Rudolph", true)
        };

    var santa = new Santa(engine, healthyReindeer);

    System.out.println("Testing flight with healthy reindeer:");
    santa.fly();

    var sickReindeer =
        new Reindeer[] {
          new Reindeer("Dasher", true),
          new Reindeer("Dancer", false),
          new Reindeer("Prancer", true),
          new Reindeer("Vixen", true),
          new Reindeer("Comet", true),
          new Reindeer("Cupid", true),
          new Reindeer("Donner", true),
          new Reindeer("Blitzen", true),
          new Reindeer("Rudolph", true)
        };

    var sickSanta = new Santa(engine, sickReindeer);
    System.out.println("\nTesting flight with sick reindeer:");
    sickSanta.fly();

    System.out.println("\nTesting gift dropping:");
    var gift = santa.dropGift();
    System.out.printf("Dropped gift: %s (%.1f kg)\n", gift.giftContent(), gift.weight());
    System.out.printf(
        "Remaining gifts in sleigh: %d\n", santa.getChristmasEngine().getGiftList().size());
  }

  private static void showcaseChild() {
    System.out.println("=== Child Showcase ===");

    var niceChild = new Child();
    System.out.printf("Is child naughty? %b\n", niceChild.getIsNaughty());

    niceChild.changeAttitude();
    System.out.printf("After attitude change - naughty? %b\n", niceChild.getIsNaughty());

    niceChild.changeAttitude();
    System.out.printf("After second change - naughty? %b\n", niceChild.getIsNaughty());

    var gift = new Gift("Nintendo Switch", 0.8f);
    niceChild.setReceivedGift(gift);
    System.out.println("\nChild opens gift:");
    niceChild.openGift();

    System.out.printf("Gift after opening: %s\n", niceChild.getReceivedGift());
  }

  private static void showcaseCompleteChristmasScenario() {
    System.out.println("=== Complete Christmas Scenario ===");

    var northPole = new ChristmasEngine("North Pole Main Factory", new ArrayList<>());
    northPole.createGift("Xbox", 4.5f);
    northPole.createGift("Barbie Dreamhouse", 3.2f);
    northPole.createGift("Hot Wheels Track", 2.8f);
    northPole.createGift("Art Supplies", 1.5f);

    System.out.printf("Factory: ");
    northPole.showName();
    System.out.printf("Total gifts ready: %d\n", northPole.getGiftList().size());
    System.out.printf("Average weight: %.2f kg\n", northPole.countAverageWeight());

    var reindeer =
        new Reindeer[] {
          new Reindeer("Dasher", true),
          new Reindeer("Dancer", true),
          new Reindeer("Prancer", true),
          new Reindeer("Vixen", true),
          new Reindeer("Comet", true),
          new Reindeer("Cupid", true),
          new Reindeer("Donner", true),
          new Reindeer("Blitzen", true),
          new Reindeer("Rudolph", true)
        };

    var santa = new Santa(northPole, reindeer);

    System.out.println("\nChecking Santa's readiness:");
    santa.fly();

    var alice = new Child();
    var bob = new Child();
    var carol = new Child();

    carol.changeAttitude();

    System.out.println("Visiting Alice (nice child):");
    santa.giveGift(alice);

    System.out.println("\nVisiting Bob (nice child):");
    santa.giveGift(bob);

    System.out.println("\nVisiting Carol (naughty child):");
    santa.giveGift(carol);

    System.out.printf(
        "Gifts remaining in sleigh: %d\n", santa.getChristmasEngine().getGiftList().size());
    System.out.printf("Total gifts created across all factories: %d\n", northPole.countGifts());
  }
}
