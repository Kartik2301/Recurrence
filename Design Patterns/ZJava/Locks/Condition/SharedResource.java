package ZJava.Locks.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private boolean isAvailable;
    private ReentrantLock lock;
    private Condition condition;

    public SharedResource(ReentrantLock lock) {
        this.lock = lock;
        isAvailable = false;
        condition = lock.newCondition();
    }

    public void addItem() {
        System.out.println(Thread.currentThread().getName() + ": thread trying to add an item");
        lock.lock();

        System.out.println(Thread.currentThread().getName() + ": Lock Acquired");

        while(isAvailable) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Put to sleep");
                condition.await();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(Thread.currentThread().getName() + ": Adding the item....");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": Item Added");
        isAvailable = true;
        condition.signalAll();
        lock.unlock();
    }

    public void removeItem() {
        System.out.println(Thread.currentThread().getName() + ": thread trying to remove an item");
        lock.lock();

        System.out.println(Thread.currentThread().getName() + ": Lock Acquired");

        while(!isAvailable) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Put to sleep");
                condition.await();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(Thread.currentThread().getName() + ": Removing the item....");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": Item Removed");
        isAvailable = false;
        condition.signalAll();
        lock.unlock();
    }
}
