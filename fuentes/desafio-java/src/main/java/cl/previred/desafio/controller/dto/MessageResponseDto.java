package cl.previred.desafio.controller.dto;


public class MessageResponseDto {

    private String message;
    private String code;

    public MessageResponseDto(MessageResponseDto messageResponseDto) {
        this.code = messageResponseDto.getCode();
        this.message = messageResponseDto.getMessage();
    }

    public MessageResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
