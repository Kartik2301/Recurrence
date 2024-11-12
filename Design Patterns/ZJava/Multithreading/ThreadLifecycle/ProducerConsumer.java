package ZJava.Multithreading.ThreadLifecycle;

public class ProducerConsumer {
    private int bufferSize = 0;
    private static final int MAX_BUF_SIZE = 5;

    public synchronized void addItem() {
        System.out.println(Thread.currentThread().getName() + " executed addItem");
        while(bufferSize == MAX_BUF_SIZE) {
            try {
                System.out.println(Thread.currentThread().getName() + " have to wait the buffer is full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        bufferSize++;
        System.out.println(Thread.currentThread().getName() + " added an item, bufferSize = " + bufferSize);
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println(Thread.currentThread().getName() + " executed consumeItem");
        while(bufferSize == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " have to wait the buffer is empty");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        bufferSize--;
        System.out.println(Thread.currentThread().getName() + " consumed an item, bufferSize = " + bufferSize);
        notifyAll();
    }
}
