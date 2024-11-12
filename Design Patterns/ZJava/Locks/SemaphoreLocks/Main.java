package ZJava.Locks.SemaphoreLocks;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore lock = new Semaphore(2);
        SharedResource sharedResource = new SharedResource(lock);
        
        Thread thread1 = new Thread(() -> sharedResource.access());
        Thread thread2 = new Thread(() -> sharedResource.access());
        Thread thread3 = new Thread(() -> sharedResource.access());
        Thread thread4 = new Thread(() -> sharedResource.access());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
