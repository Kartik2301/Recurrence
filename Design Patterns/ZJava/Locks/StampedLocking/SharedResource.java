package ZJava.Locks.StampedLocking;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    private String studentName;
    private StampedLock lock;

    public SharedResource(StampedLock lock) {
        studentName = "Jax Jordann";
        this.lock = lock;
    }

    public void consume() {
        long stamp = lock.readLock();
        System.out.println(Thread.currentThread().getName() + ": wants to consume an item");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +  ": Consumed an item");
        lock.unlockRead(stamp);
    }

    public void produce() {
        long stamp = lock.writeLock();
        System.out.println(Thread.currentThread().getName() + ": wants to add an item");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +  ": Added an item");
        lock.unlockWrite(stamp);
    }

    public void nonOptimisticUpdate() {
        System.out.println(Thread.currentThread().getName() + ": Going to update the record, current record is: " + this.studentName);
        long stamp = lock.writeLock();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +  ": Added an item");
        lock.unlockWrite(stamp);
    }

    public void optimisticRecordUpdate() {
        long stamp = lock.tryOptimisticRead();
        System.out.println(Thread.currentThread().getName() + ": Going to update the record, current record is: " + this.studentName);

        // Update performed
        String data = this.studentName;

        // Before writing validate the stamp
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(lock.validate(stamp)) {
            // Good to update
            this.studentName = "Kennith Marthown";
            System.out.println(Thread.currentThread().getName() + ": Successfully updated the record");
        } else {
            // Rollback
            this.studentName = data;
            System.out.println(Thread.currentThread().getName() + ": Cannot update the record, version ID mismatch");
        }
    }
}
