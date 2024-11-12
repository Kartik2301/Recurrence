package ZJava.Locks.SemaphoreLocks;

import java.util.concurrent.Semaphore;

public class SharedResource {
    private Semaphore lock;

    public SharedResource(Semaphore lock) {
        this.lock = lock;
    }

    public void access() {
        System.out.println(Thread.currentThread().getName() + ": Trying to access the Resource");

        try {
            lock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": Lock Acquired, Using the Resource");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": Done using the Resource");

        lock.release();
    }
}
