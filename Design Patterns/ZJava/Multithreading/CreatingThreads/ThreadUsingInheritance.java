package ZJava.Multithreading.CreatingThreads;

public class ThreadUsingInheritance extends Thread {
    @Override
    public void run() {
        System.out.println("Sending packets over a network: " + Thread.currentThread().getName());
    }
}
