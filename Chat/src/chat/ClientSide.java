package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author jlso
 */
public class ClientSide implements Runnable {

    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;
    private String address;
    private int port;

    public ClientSide(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public static void main(String[] args) {
        ClientSide client = new ClientSide("192.168.1.6", 5000);
    }

    @Override
    public void run() {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("$usuario:Janine$");
        } catch (UnknownHostException u) {
            System.out.println(u);
            System.exit(1);
        } catch (IOException i) {
            System.out.println(i);
            System.exit(1);
        }

        String line = "";

        while (!line.equals("Bora parar?")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}
