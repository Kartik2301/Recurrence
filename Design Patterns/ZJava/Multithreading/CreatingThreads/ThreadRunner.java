package ZJava.Multithreading.CreatingThreads;

public class ThreadRunner implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading files from the internet, Thread Name: " + Thread.currentThread().getName());
    }
    
}
