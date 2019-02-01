package sendobjecttcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serv extends Thread {

    private ServerSocket serverSkt;
    private Socket skt;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public serv() {
       
    }

    public Socket getSocket() {
        try {
            while (true) {
                serverSkt = new ServerSocket(1235);
                skt = serverSkt.accept();
                return skt;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
             return null;
        }
    }

    @Override
    public void run() {
        getSocket();  }

    public static void main(String[] args) {
        new serv().start();
    }
}
