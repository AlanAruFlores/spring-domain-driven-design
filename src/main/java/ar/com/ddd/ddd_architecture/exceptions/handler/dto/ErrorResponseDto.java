package ar.com.ddd.ddd_architecture.exceptions.handler.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private Integer code;
    private String message;
    private String detail;
}