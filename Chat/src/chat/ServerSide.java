package chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jlso
 */

public class ServerSide implements Runnable{

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private int port;

    public ServerSide(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        ServerSide server = new ServerSide(5000);
    }

    @Override
    public void run() {
        
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            System.out.println("");
            String nome = null;
            while (true) {
                try {
                    line = in.readUTF();
                    //line = input.readLine();
                    if (nome != null) {
                        System.out.println(nome + ": " + line);
                    } else {
                        nome = line.split(":")[1].replace("$", "").strip();
                    }
                } catch (EOFException i) {
                    break;
                } catch (IOException i) {
                    System.out.println(i);
                }
            }

            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
        
    }
}