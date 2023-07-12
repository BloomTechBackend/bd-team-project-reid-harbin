package api.touchbase.exceptions;

public class UsernameTakenException extends InvalidInputException{
    public UsernameTakenException() {
        super();
    }
    public UsernameTakenException(String message) {
        super(message);
    }
    public UsernameTakenException(Throwable cause) {
        super(cause);
    }
    public UsernameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
