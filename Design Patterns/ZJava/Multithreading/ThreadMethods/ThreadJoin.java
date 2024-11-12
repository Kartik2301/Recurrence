package ZJava.Multithreading.ThreadMethods;

public class ThreadJoin {
    public static void main(String[] args) {
        System.out.println("Main method executed");

        Thread thread = new Thread(() -> {
            System.out.println("Lock Acquired");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Lock Released");
        });

        thread.start();

        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main method finished execution");
    }
}
