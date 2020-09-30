package learn.errorandexceptions.exceptions;

public class NoStudentClassesException extends RuntimeException {

    public NoStudentClassesException(String student) {
        super("No student classes for student " + student);
    }

    public NoStudentClassesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentClassesException(Throwable cause) {
        super(cause);
    }
}
