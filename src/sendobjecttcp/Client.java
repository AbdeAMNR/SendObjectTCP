package sendobjecttcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author amnrLaptop
 */
public class Client extends Thread {

    private Socket skt;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Scanner sc;

    public Client() {
    }

    @Override
    public void run() {
        try {
            skt = new Socket("127.0.0.1", 1235);
            oos = new ObjectOutputStream(skt.getOutputStream());
            ois = new ObjectInputStream(skt.getInputStream());
            while (true) {
                try {
                    System.out.println("ask to send a person");
                    sc = new Scanner(System.in);
                    String str = sc.next();
                    oos.writeObject(str);
                    Personne pp = (Personne) ois.readObject();
                    pp.afficher();
                    System.out.println("--------------------------------");

                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client().start();
    }
}
