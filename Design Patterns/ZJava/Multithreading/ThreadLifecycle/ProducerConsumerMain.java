package ZJava.Multithreading.ThreadLifecycle;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                producerConsumer.addItem();
            }
        });

        Thread consumeThread = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                producerConsumer.consumeItem();
            }
        });

        producerThread.start();
        consumeThread.start();
    }   
}
