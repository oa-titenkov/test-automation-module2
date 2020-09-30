package learn.errorandexceptions.exceptions;

public class NoFacultiesInUniversityException extends RuntimeException {

    public NoFacultiesInUniversityException() {
        super();
    }

    public NoFacultiesInUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFacultiesInUniversityException(Throwable cause) {
        super(cause);
    }
}
