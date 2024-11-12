package ZJava.Multithreading.ThreadLifecycle;

public class SharedResource {
    private boolean itemAvailable = false;

    public synchronized void addItem() {
        System.out.println("addItem called by: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Item added by: " + Thread.currentThread().getName());
        itemAvailable = true;
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("consumeItem called by: " + Thread.currentThread().getName());
        while (!itemAvailable) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        itemAvailable = false;
        System.out.println("Item Consumed by: " + Thread.currentThread().getName());
    }
}
