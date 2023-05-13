package api.touchbase.exceptions;

public class MemberHasFamilyException extends RuntimeException {
    public MemberHasFamilyException() {
        super();
    }
    public MemberHasFamilyException(String message) {
        super(message);
    }
    public MemberHasFamilyException(Throwable cause) {
        super(cause);
    }
    public MemberHasFamilyException(String message, Throwable cause) {
        super(message, cause);
    }

}
