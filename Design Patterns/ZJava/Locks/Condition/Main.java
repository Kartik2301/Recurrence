package ZJava.Locks.Condition;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource(lock);

        Thread producerThread = new Thread(() -> sharedResource.addItem());
        Thread consumerThread = new Thread(() -> sharedResource.removeItem());

        producerThread.start();
        consumerThread.start();
    }
}
