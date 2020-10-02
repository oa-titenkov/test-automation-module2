package learn.threads.maintask.exceptions;

public class OverloadCapacityException extends RuntimeException {

    public OverloadCapacityException(String message) {
        super(message);
    }

    public OverloadCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverloadCapacityException(Throwable cause) {
        super(cause);
    }
}
