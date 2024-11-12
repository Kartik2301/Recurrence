package ChainOfResponsibilityDesignPattern.Logger;

public class InfoLogHandler extends LogHandler {
    public InfoLogHandler(LogHandler nextLogHandler) {
        super(nextLogHandler);
    }

    public void log(LogType logType, String message) {
        if(logType == LogType.INFO) {
            System.out.println("INFO: " + message);
        } else {
            super.log(logType, message);
        }
    }
}
