package ar.com.ddd.ddd_architecture.exceptions.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ar.com.ddd.ddd_architecture.exceptions.InternalException;
import ar.com.ddd.ddd_architecture.exceptions.NotFoundException;
import ar.com.ddd.ddd_architecture.exceptions.handler.dto.ErrorResponseDto;


@ControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ErrorResponseDto> handleEmptyException(InternalException ex) {
        return ResponseEntity
        .status(ex.getCode())
        .body(ErrorResponseDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detail(ex.getDetail())
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity
        .status(ex.getCode())
        .body(ErrorResponseDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detail(ex.getDetail())
                .build());
    }

}