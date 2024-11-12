package ZJava.Locks.MonitorLocks;

public class Main {
    public static void main(String[] args) {
        DataExchange dataExchange = new DataExchange();
        Runnable threadRunner = new ThreadRunner(dataExchange);

        Thread thread1 = new Thread(() -> dataExchange.sendData());
        Thread thread2 = new Thread(threadRunner);
        Thread thread3 = new Thread(() -> dataExchange.receiveBroadcast());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
