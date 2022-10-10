package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private Logger log1;
    private Logger log2;

    public CompositeLogger(Logger first, Logger second){
        this.log1 = first;
        this.log2 = second;
    }

    @Override
    public void log(String message) {
        log1.log(message);
        log2.log(message);
    }
}
