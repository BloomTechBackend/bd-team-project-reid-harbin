package api.touchbase.exceptions;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException() {
        super();
    }

    public MemberNotFoundException(String message) {
        super(message);
    }

    public MemberNotFoundException(Throwable cause) {
        super(cause);
    }

    public MemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
