package distributedsupershop;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
     ObjectInputStream inputStream = null;
ObjectOutputStream outputStream = null;
    PrintStream printStrm; Scanner scanner;Socket s;
    public Client(String ipAddress, int port) {
        try {//ipAddress = "127.0.0.1" for local host, port 6666 usually
            s = new Socket(ipAddress, port);
            scanner = new Scanner(s.getInputStream());
            printStrm = new PrintStream(s.getOutputStream());
            outputStream = new ObjectOutputStream(s.getOutputStream());
            inputStream = new ObjectInputStream(s.getInputStream());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
