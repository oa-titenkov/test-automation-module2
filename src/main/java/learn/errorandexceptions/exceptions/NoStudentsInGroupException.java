package learn.errorandexceptions.exceptions;

public class NoStudentsInGroupException extends RuntimeException {

    public NoStudentsInGroupException(String group) {
        super("No students in group " + group);
    }

    public NoStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupException(Throwable cause) {
        super(cause);
    }
}
