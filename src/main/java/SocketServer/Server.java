package SocketServer;

import Logger.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements AutoCloseable {

  ServerSocket serverSocket;
  final int port;

  public Server() {
    this.port = 8080;
  }

  public Server(int port) {
    this.port = port;
  }

  public void start() {
    getServerSocket();
  }

  public void listen() {
    if (serverSocket == null) {
      Logger.getCriticalError(
          new IllegalStateException(), "listen method, Server socket is not initialized.");
    }

    try (Socket clientSocket = serverSocket.accept();
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
      Logger.getInfo("Connected to a client " + clientSocket.getPort());

      out.println("TEST TEST TEST TEST");

      String inputLine;
      while((inputLine = in.readLine()) != null) {
        if (inputLine.equals("&")) {
          out.println("Closing connection.");
          Logger.getInfo("Closed connection with the client: " + clientSocket.getPort());
          break;
        }
        Logger.getMessage("Client: " + inputLine);
        out.println("Server: " + inputLine);
      }
    } catch (Exception e) {
      Logger.getException(e, "listen method, in try body/block.");
    }
  }

  private void getServerSocket() {
    try {
      this.serverSocket = new ServerSocket(this.port);
    } catch (Exception e) {
      Logger.getCriticalError(e, "getServerSocket on ServerSocket initialisation");
    }
  }

  private void stop() {
    try {
      this.serverSocket.close();
    } catch (Exception e) {
      Logger.getException(e, "stop on ServerSocket stopping.");
    }
  }

  @Override
  public void close() {
    stop();
  }
}