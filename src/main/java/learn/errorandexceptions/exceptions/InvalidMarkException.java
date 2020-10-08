package learn.errorandexceptions.exceptions;

public class InvalidMarkException extends RuntimeException {

    public InvalidMarkException(int mark) {
        super("Mark < 0 or > 10! (" + mark + ")");
    }

    public InvalidMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMarkException(Throwable cause) {
        super(cause);
    }
}
