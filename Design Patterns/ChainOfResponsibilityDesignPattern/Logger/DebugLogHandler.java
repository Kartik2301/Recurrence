package ChainOfResponsibilityDesignPattern.Logger;

public class DebugLogHandler extends LogHandler {
    public DebugLogHandler(LogHandler nextLogHandler) {
        super(nextLogHandler);
    }

    public void log(LogType logType, String message) {
        if(logType == LogType.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logType, message);
        }
    }
}
