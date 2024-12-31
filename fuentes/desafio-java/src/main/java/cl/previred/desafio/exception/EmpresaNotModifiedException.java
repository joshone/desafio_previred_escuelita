package cl.previred.desafio.exception;

public class EmpresaNotModifiedException extends ValidationException {

    private static final long serialVersionUID = 3946460569471770939L;

    public EmpresaNotModifiedException() {
        super();
    }

    public EmpresaNotModifiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmpresaNotModifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaNotModifiedException(String message) {
        super(message);
    }

    public EmpresaNotModifiedException(Throwable cause) {
        super(cause);
    }
}
