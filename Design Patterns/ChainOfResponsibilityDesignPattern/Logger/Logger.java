package ChainOfResponsibilityDesignPattern.Logger;

public class Logger {
    public static void main(String [] args) {
        LogHandler logHandler = new InfoLogHandler(new DebugLogHandler(new ErrorLogHandler(null)));
        logHandler.log(LogType.ERROR, "This is a catastrophic error, the company is down");
        logHandler.log(LogType.INFO, "This is to inform you that you are a weasel");
        logHandler.log(LogType.DEBUG, "This is a stupid debug message, but hey you are even more stupid");
    }
}
