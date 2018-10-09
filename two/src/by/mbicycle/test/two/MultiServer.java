package by.mbicycle.test.two;

import java.io.*;
import java.net.*;
/**
 *  Main
 * @author Stas Nesteruk
 */
public class MultiServer {
    //Declare port
    private static final int PORT = 8020;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT);){
            System.out.println("Server Started");
            while (!server.isClosed()) {
                Socket client = server.accept();
                System.out.println("Client connected");
                try{
                    new MonoClientHandler(client);
                }
                catch (Exception e) {
                    client.close();
                }
            }
        }
    }
}