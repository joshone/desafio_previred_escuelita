package cl.previred.desafio.exception;

public class EmpresaAlreadyExistException extends ValidationException {

    private static final long serialVersionUID = 3946460569471770939L;

    public EmpresaAlreadyExistException() {
        super();
    }

    public EmpresaAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmpresaAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaAlreadyExistException(String message) {
        super(message);
    }

    public EmpresaAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
