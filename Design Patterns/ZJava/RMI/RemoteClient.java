package ZJava.RMI;

import java.rmi.Naming;

public class RemoteClient {
    public static void main(String[] args) {
        try {
            RemoteInterface service = (RemoteInterface) Naming.lookup("rmi://localhost:1900/HelloRemoteService");
            String data = service.sayHello();

            System.out.println(data);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
