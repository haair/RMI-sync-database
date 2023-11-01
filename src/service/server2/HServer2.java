package service.server2;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HServer2 {
    public static void main(String[] args) throws IOException {
        try {
            Server2Imp server2Imp = new Server2Imp();
            Registry registry = LocateRegistry.createRegistry(2004);
            registry.rebind("hello", server2Imp);
            System.out.println("Server 2 is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
