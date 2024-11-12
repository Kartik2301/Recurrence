package ZJava.Locks.MonitorLocks;

public class ThreadRunner implements Runnable {
    DataExchange dataExchange;

    public ThreadRunner(DataExchange dataExchange) {
        this.dataExchange = dataExchange;
    }

    @Override
    public void run() {
        dataExchange.establishCommunication();
    }
    
}
