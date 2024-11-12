package ZJava.Locks.MonitorLocks;

public class DataExchange {
    public void log(String data) {
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + ": " + data + " .....");
    }

    public synchronized void sendData() {
        try {
            log("Sending Data overseas");
            Thread.sleep(5000);
            log("Data Transmission done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void establishCommunication() {
        log("About to establish communication");
        synchronized(this) {
            log("Communication Established with Mr. Penguin from the Arctic");
            try {
                Thread.sleep(3000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            log("Hanging up now");
        }
    }

    public void receiveBroadcast() {
        log("Broadcast Received, data logged in the Library");
    }
}
