package ZJava.Exception;

public class SampleException {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }        
    }
}
