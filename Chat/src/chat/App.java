package chat;

/**
 *
 * @author jlso
 */

public class App {
    public static void main(String[] args) {
        
        ServerSide s = new ServerSide(5000);
        ClientSide c = new ClientSide("192.168.1.6", 5000);
        
        Thread threadServer = new Thread(s);
        Thread threadClient = new Thread(c);
        
        threadClient.start();
        threadServer.start();
       
    }
}
