package ZJava.Exception.CustomExceptions;

public class CustomUnCheckedException extends RuntimeException {
    public CustomUnCheckedException() {}

    public CustomUnCheckedException(String message) {
        super(message);
    }
}
