package cl.previred.desafio.controller;

import cl.previred.desafio.controller.dto.BaseResponseDto;
import cl.previred.desafio.controller.dto.ResultCodeDto;
import cl.previred.desafio.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmpresaAlreadyExistException.class})
    public final BaseResponseDto<Void> handleEmpresaAlreadyExistException(EmpresaAlreadyExistException exception) {
        log.error("handleEmpresaAlreadyExistException", exception);
        return new BaseResponseDto<>(ResultCodeDto.ERROR, "Empresa ya existe", null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmpresaNotFoundException.class})
    public final BaseResponseDto<Void> handleEmpresaNotFoundException(EmpresaNotFoundException exception) {
        log.error("handleEmpresaNotFoundException", exception);
        return new BaseResponseDto<>(ResultCodeDto.ERROR, "Empresa no encontrado", null);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({EmpresaNotModifiedException.class})
    public final BaseResponseDto<Void> handleEmpresaNotModifiedException(EmpresaNotModifiedException exception) {
        log.error("handleEmpresaNotModifiedException", exception);
        return new BaseResponseDto<>(ResultCodeDto.ERROR, "Empresa no nodificado", null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TrabajadorNotFoundException.class})
    public final BaseResponseDto<Void> handleTrabajadorNotFoundException(TrabajadorNotFoundException exception) {
        log.error("handleTrabajadorNotFoundException", exception);
        return new BaseResponseDto<>(ResultCodeDto.ERROR, "Trabajador no encontrado", null);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({TrabajadorNotCreatedException.class})
    public final BaseResponseDto<Void> handleTrabajadorNotCreatedException(TrabajadorNotCreatedException exception) {
        log.error("handleTrabajadorNotCreatedException", exception);
        return new BaseResponseDto<>(ResultCodeDto.ERROR, "Trabajador no creado", null);
    }



}
