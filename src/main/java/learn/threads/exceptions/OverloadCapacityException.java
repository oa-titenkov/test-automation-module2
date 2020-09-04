package learn.threads.exceptions;

public class OverloadCapacityException extends Exception {

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
