package api.touchbase.exceptions;

public class EventNotFoundException extends InvalidInputException {
    public EventNotFoundException () {
        super();
    }
    public EventNotFoundException (String message) {
        super(message);
    }
    public EventNotFoundException (Throwable cause) {
        super(cause);
    }
    public EventNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }

}
