import java.lang.RuntimeException;

public class FullQueueException extends RuntimeException{
    public FullQueueException(String msg) {
        super(msg);
    }

    public FullQueueException(String msg, Exception e) {
        super(msg, e);
    }
}
