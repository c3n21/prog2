import java.lang.RuntimeException;

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(String msg) {
        super(msg);
    }
    public EmptyQueueException(String msg, Exception e) {
        super(msg, e);
    }
}
