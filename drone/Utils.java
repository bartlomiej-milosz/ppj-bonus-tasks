package drone;

class Utils {
  private static int counter = 0;
  private static final short MIN = 100;
  private static final short RANGE = 900;
  private static final short MULTIPLIER = 1000;
  private static final short PREFIX = (short) ((Math.random() * RANGE) + MIN);

  private Utils() {}

  /**
   * Generates unique identifier for objects in standalone applications.
   *
   * @return unique integer ID
   */
  static int generateId() {
    return PREFIX * MULTIPLIER + counter++;
  }
}
