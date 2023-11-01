package service.client;

import service.IServerSync;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class HClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry("localhost", 2003);
            IServerSync text = (IServerSync) registry.lookup("hello");
//            String content = "ahihi";
//            text.addText(content);
//            text.sync(content);
//            System.out.println("<3");
            while (true) {
                String content = scanner.nextLine();
                text.addText(content);
                text.sync(content);
                System.out.println("Send ok!");
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
