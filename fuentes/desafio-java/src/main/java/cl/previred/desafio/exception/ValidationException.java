package cl.previred.desafio.exception;

public class ValidationException extends Exception {

    private static final long serialVersionUID = 2297108523480782057L;

    public ValidationException() {
        super();
    }

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
