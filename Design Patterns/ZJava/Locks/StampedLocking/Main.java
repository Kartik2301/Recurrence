package ZJava.Locks.StampedLocking;

import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) {
        StampedLock lock = new StampedLock();

        SharedResource sharedResource = new SharedResource(lock);

        // Code for examining Stamped Lock's behaviour as ReadWrite lock

        // Thread thread1 = new Thread(() -> sharedResource.consume());
        // Thread thread2 = new Thread(() -> sharedResource.consume());
        
        // Thread thread3 = new Thread(() -> sharedResource.produce());

        // thread1.start();
        // thread2.start();
        // thread3.start();

        // Optimistic Locking

        Thread thread4 = new Thread(() -> sharedResource.optimisticRecordUpdate());
        Thread thread5 = new Thread(() -> sharedResource.nonOptimisticUpdate());

        thread4.start();
        thread5.start();
    }
}
