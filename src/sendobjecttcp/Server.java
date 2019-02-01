package sendobjecttcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket serverSkt;
    private Socket skt;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Server() {
        try {
            serverSkt = new ServerSocket(1235);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            while (true) {
                skt = serverSkt.accept();
                oos = new ObjectOutputStream(skt.getOutputStream());
                ois = new ObjectInputStream(skt.getInputStream());
                String str = (String) ois.readObject();
                System.out.println("voila le magic key ==> " + str);
                if (str.equals("send")) {
                    Personne p2 = new Personne("abde", "AMNR", "Agadir");
                    oos.writeObject(p2);
                } else {
                    oos.writeObject("dffsfsdsq");
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
