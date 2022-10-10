package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private String className;
    private Logger delegateLogger;
    private final DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ContextualLogger(String className, Logger delegateLogger)
    {
        this.className = className;
        this.delegateLogger = delegateLogger;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatt) + " " + className + " " + message);
    }
}
