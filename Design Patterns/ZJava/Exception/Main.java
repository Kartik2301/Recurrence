package ZJava.Exception;

public class Main {
    public static void main(String[] args) {
        ThrowException exception = new ThrowException();

        exception.history();
        exception.invokeRawType();
        exception.caller();

        try {
            exception.callerMethod();
        } catch(ClassCastException cce) {
            System.out.println("Can be an unchecked exception, but still got to be handled right.");
        }
        

        System.out.println("Hi do we reach here, hell no");
    }
}
