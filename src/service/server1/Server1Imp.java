package service.server1;

import service.IServerSync;

import service.IServerSync;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Server1Imp extends UnicastRemoteObject implements IServerSync {
    protected Server1Imp() throws RemoteException {
    }

    protected Server1Imp(int port) throws RemoteException {
        super(port);
    }

    protected Server1Imp(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void addText(String content) throws RemoteException {
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter("src/service/server1/data1.txt", true));
            output.append(content + System.lineSeparator());
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void syncWithServer2(String content) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2004);
        IServerSync text = (IServerSync) registry.lookup("hello");
        text.addText(content);
        System.out.println("<3");
    }

    @Override
    public void sync(String data) {
        try {
            syncWithServer2(data);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
