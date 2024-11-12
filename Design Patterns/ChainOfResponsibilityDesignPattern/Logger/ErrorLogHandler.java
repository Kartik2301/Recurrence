package ChainOfResponsibilityDesignPattern.Logger;

public class ErrorLogHandler extends LogHandler {
    public ErrorLogHandler(LogHandler nextLogHandler) {
        super(nextLogHandler);
    }

    public void log(LogType logType, String message) {
        if(logType == LogType.ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logType, message);
        }
    }
}
