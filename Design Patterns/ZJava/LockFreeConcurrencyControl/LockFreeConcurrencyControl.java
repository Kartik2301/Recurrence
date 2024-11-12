package ZJava.LockFreeConcurrencyControl;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFreeConcurrencyControl {
    private AtomicInteger atomicLong;

    public LockFreeConcurrencyControl() {
        this.atomicLong = new AtomicInteger();
    }

    public void increment() {
        atomicLong.incrementAndGet();
    }

    public int getCounter() {
        return atomicLong.get();
    }
}
