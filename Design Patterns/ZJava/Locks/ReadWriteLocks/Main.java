package ZJava.Locks.ReadWriteLocks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResouce sharedResouce1 = new SharedResouce(lock);

        Thread thread1 = new Thread(() -> sharedResouce1.consume());
        Thread thread2 = new Thread(() -> sharedResouce1.consume());
        Thread thread3 = new Thread(() -> sharedResouce1.consume());

        SharedResouce sharedResouce2 = new SharedResouce(lock);
        Thread thread4 = new Thread(() -> sharedResouce2.produce());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
