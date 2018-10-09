package by.mbicycle.test.two;

import java.io.*;
import java.net.*;
/**
 *  Main
 * @author Stas Nesteruk
 */
class MonoClientHandler extends Thread {

    private Socket socket;

    //Constructor
    public MonoClientHandler(Socket socket){
        this.socket = socket;
        start();
    }

    //Override method run
    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                     .getOutputStream())), true);){
            while (!socket.isClosed()) {
                String message = in.readLine();
                if (message.equals("exit")) break;
                System.out.println("Echoing: " + message);
                out.println(message);
            }
            System.out.println("Connection closed");
            socket.close();
        }
        catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}