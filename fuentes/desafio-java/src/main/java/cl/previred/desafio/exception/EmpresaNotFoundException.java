package cl.previred.desafio.exception;

public class EmpresaNotFoundException extends ValidationException {

    private static final long serialVersionUID = 3946460569471770939L;

    public EmpresaNotFoundException() {
        super();
    }

    public EmpresaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmpresaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaNotFoundException(String message) {
        super(message);
    }

    public EmpresaNotFoundException(Throwable cause) {
        super(cause);
    }
}
