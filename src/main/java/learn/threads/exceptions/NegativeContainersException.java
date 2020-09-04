package learn.threads.exceptions;

public class NegativeContainersException extends Exception {

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
