package api.touchbase.exceptions;

public class FamilyNotFoundException extends NotFoundException {
    public FamilyNotFoundException() {
        super();
    }

    public FamilyNotFoundException(String message) {
        super(message);
    }

    public FamilyNotFoundException(Throwable cause) {
        super(cause);
    }

    public FamilyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
