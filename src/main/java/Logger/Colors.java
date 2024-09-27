package Logger;

/**
 * Class for Coloring Logger messages and other things.
 */
public class Colors {

  private static final String RESET  = "\u001B[0m";
  private static final String BLACK  = "\u001B[30m";
  private static final String RED    = "\u001B[31m";
  private static final String GREEN  = "\u001B[32m";
  private static final String YELLOW = "\u001B[33m";
  private static final String BLUE   = "\u001B[34m";
  private static final String PURPLE = "\u001B[35m";
  private static final String CYAN   = "\u001B[36m";
  private static final String WHITE  = "\u001B[37m";

  /**
   * Colors the String with provided color
   * @param message string to color.
   * @param color of enum type Color
   * @return colored string.
   */
  public static String colorString(String message, Color color) {
    return pickColor(color) + message + RESET;
  }

  /**
   * Pick a color and return it, if color doesn't exist return RESET.
   * @param color of enum type Color
   * @return coloring string
   */
  private static String pickColor(Color color) {
    switch (color) {
      case RED:
        return RED;
      case BLUE:
        return BLUE;
      case CYAN:
        return CYAN;
      case BLACK:
        return BLACK;
      case GREEN:
        return GREEN;
      case WHITE:
        return WHITE;
      case PURPLE:
        return PURPLE;
      case YELLOW:
        return YELLOW;
      default:
        Logger.getException(new Exception("No such color"), "pickColor method at Colors class.");
        return RESET;
    }
  }
}
