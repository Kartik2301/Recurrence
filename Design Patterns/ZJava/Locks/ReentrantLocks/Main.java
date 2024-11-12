package ZJava.Locks.ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> new SharedResource(lock).access());
        Thread thread2 = new Thread(() -> new SharedResource(lock).access());

        thread1.start();
        thread2.start();
    }
}
