import SocketServer.Server;

public class Main {
  public static void main(String[] args) {
    try (Server server = new Server()) {
      server.start();
      server.listen();
    }
    return;
  }
}
