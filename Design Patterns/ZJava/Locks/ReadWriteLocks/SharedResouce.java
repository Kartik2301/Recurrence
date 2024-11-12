package ZJava.Locks.ReadWriteLocks;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResouce {
    private ReadWriteLock lock; 
    int count;

    public SharedResouce(ReadWriteLock lock) {
        this.lock = lock;
        this.count = 0;
    }

    public void produce() {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + ": Adding Data to the stream ...");
        
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + ": Added Data to the stream ...");
        lock.writeLock().unlock();
    }

    public void consume() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + ": Reading Data from the stream ...");
        
        try {
            Thread.sleep(8000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": Data Read ...");
        lock.readLock().unlock();
    }
}
