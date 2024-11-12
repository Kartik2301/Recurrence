package ZJava.RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {
    private static final long serialVersionUID = 1L;
    public RemoteImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello Remote Client";
    }

    public static void main(String[] args) {
        try {
            RemoteImpl remote = new RemoteImpl();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/HelloRemoteService", remote);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    
}
