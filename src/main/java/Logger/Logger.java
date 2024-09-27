package Logger;

public class Logger {
  static public void getException(Exception e, String where) {
    System.err.printf(
        "Exception of type %s.\nOccurred at %s.\n",
        e.getMessage(), where
    );
  }

  static public void getCriticalError(Exception e ,String where) {
    System.err.printf(
        "Critical error %s at %s\nFurther work is impossible.\n",
        e, where
    );

    assert false;
  }

  static public void getInfo(String info) {
    System.out.println(info);
  }

  static public void getMessage(String message) {
    System.out.println(message);
  }
}
