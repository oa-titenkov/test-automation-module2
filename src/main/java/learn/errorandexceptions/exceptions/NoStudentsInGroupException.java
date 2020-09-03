package learn.errorandexceptions.exceptions;

public class NoStudentsInGroupException extends Exception {

    public NoStudentsInGroupException(String group) {
        super("No student in group " + group);
    }

    public NoStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupException(Throwable cause) {
        super(cause);
    }
}
