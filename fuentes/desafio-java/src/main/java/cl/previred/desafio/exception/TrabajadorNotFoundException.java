package cl.previred.desafio.exception;

public class TrabajadorNotFoundException extends ValidationException {

    private static final long serialVersionUID = 3946460569471770939L;

    public TrabajadorNotFoundException() {
        super();
    }

    public TrabajadorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TrabajadorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrabajadorNotFoundException(String message) {
        super(message);
    }

    public TrabajadorNotFoundException(Throwable cause) {
        super(cause);
    }
}
