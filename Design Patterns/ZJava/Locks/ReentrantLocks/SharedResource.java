package ZJava.Locks.ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    ReentrantLock lock;

    public SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }

    public void access() {
        System.out.println(Thread.currentThread().getName() + ": called access");

        // Critical Section
        lock.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": relinquish access");
        lock.unlock();
    }
}
