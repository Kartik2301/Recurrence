package ChainOfResponsibilityDesignPattern.Logger;

public abstract class LogHandler {
    LogHandler nextLogHandler;

    public LogHandler(LogHandler nextLogHandler) {
        this.nextLogHandler = nextLogHandler;
    }

    public void log(LogType logType, String message) {
        if(nextLogHandler != null) {
            nextLogHandler.log(logType, message);
        }
    }
}
