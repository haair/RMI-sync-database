package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerSync extends Remote {
    public void addText(String content) throws RemoteException;
    public void sync(String data) throws RemoteException;
}
