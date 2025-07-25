package ConcurrencyModule.VirtualThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;

class StructuredTask implements Callable<String> {

    private int timeToSleep;
    private String result;

    public StructuredTask(int timeToSleep, String result) {
        this.timeToSleep = timeToSleep;
        this.result = result;
    }
}

public class StructuredConcurrency {
    public static void main(String[] args) {
        try(StructuredTaskScope<String> scope = new StructuredTaskScope<>()) {
            
        }
    }
}
