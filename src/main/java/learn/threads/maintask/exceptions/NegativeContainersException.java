package learn.threads.maintask.exceptions;

public class NegativeContainersException extends RuntimeException {

    public NegativeContainersException(String message) {
        super(message);
    }

    public NegativeContainersException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeContainersException(Throwable cause) {
        super(cause);
    }
}
