package ZJava.Multithreading.ThreadLifecycle;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println("Main Method Invocation");
            resource.consumeItem();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Car Method Invocation");
            resource.addItem();
        });

        thread1.start();
        thread2.start();
    }
}
