package cl.previred.desafio.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"resul", "message", "code"})
public class BaseResponseDto <T> extends MessageResponseDto {

    private ResultCodeDto result;
    T data;
    List<String> errors;

    public ResultCodeDto getResult() {
        return result;
    }

    public void setResult(ResultCodeDto result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public BaseResponseDto(ResultCodeDto result, String message, T data) {
        super(message);
        this.result = result;
        this.data = data;
    }

    public BaseResponseDto(ResultCodeDto result, String message) {
        super(message);
        this.result = result;
    }

    public BaseResponseDto(ResultCodeDto result, String message, List<String> errors) {
        super(message);
        this.result = result;
        this.errors = errors;
    }

    public BaseResponseDto(ResultCodeDto result, MessageResponseDto messageResponseDto, T data) {
        super(messageResponseDto);
        this.result = result;
        this.data = data;
    }

    public BaseResponseDto(ResultCodeDto result, MessageResponseDto messageResponseDto, List<String> errors) {
        super(messageResponseDto);
        this.result = result;
        this.errors = errors;
    }

    public BaseResponseDto(ResultCodeDto result, MessageResponseDto messageResponseDto) {
        super(messageResponseDto);
        this.result = result;
    }
}
