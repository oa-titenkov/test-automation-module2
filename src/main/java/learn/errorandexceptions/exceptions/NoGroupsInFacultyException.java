package learn.errorandexceptions.exceptions;

public class NoGroupsInFacultyException extends Exception {

    public NoGroupsInFacultyException(String faculty) {
        super("No groups for faculty " + faculty);
    }

    public NoGroupsInFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsInFacultyException(Throwable cause) {
        super(cause);
    }
}
