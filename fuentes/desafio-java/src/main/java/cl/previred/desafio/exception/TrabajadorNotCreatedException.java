package cl.previred.desafio.exception;

public class TrabajadorNotCreatedException extends ValidationException {

    private static final long serialVersionUID = 3946460569471770939L;

    public TrabajadorNotCreatedException() {
        super();
    }

    public TrabajadorNotCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TrabajadorNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrabajadorNotCreatedException(String message) {
        super(message);
    }

    public TrabajadorNotCreatedException(Throwable cause) {
        super(cause);
    }
}
