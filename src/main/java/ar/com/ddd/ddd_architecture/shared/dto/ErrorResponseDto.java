package ar.com.ddd.ddd_architecture.shared.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private Integer code;
    private String message;
    private String detail;
}