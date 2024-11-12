package ZJava.LockFreeConcurrencyControl;

public class Main {
    public static void main(String[] args) {
        // RaceCondition raceCondition = new RaceCondition();
        LockFreeConcurrencyControl raceCondition = new LockFreeConcurrencyControl();

        // Race Condition
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                raceCondition.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                raceCondition.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(raceCondition.getCounter());
    }
}
