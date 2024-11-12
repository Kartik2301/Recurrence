package ZJava.Multithreading.CreatingThreads;

public class Main {
    public static void main(String[] args) {
        Runnable threadRunnable = new ThreadRunner();
        Thread thread = new Thread(threadRunnable);

        thread.start();
        System.out.println("Thread Name, Main method: " + Thread.currentThread().getName());

        ThreadUsingInheritance threadUsingInheritance = new ThreadUsingInheritance();
        threadUsingInheritance.start();
    }
}
