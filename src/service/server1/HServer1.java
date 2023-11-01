package service.server1;

import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HServer1 {
    public static void main(String[] args) throws IOException {
        try {
            Server1Imp server1Imp = new Server1Imp();
            Registry registry = LocateRegistry.createRegistry(2003);
            registry.rebind("hello", server1Imp);
            System.out.println("Server 1 is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
