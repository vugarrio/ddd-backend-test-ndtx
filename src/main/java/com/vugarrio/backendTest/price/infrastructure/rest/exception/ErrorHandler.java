package com.vugarrio.backendTest.price.infrastructure.rest.exception;

import com.vugarrio.backendTest.price.domain.exception.DateWrongFormatException;
import com.vugarrio.backendTest.price.infrastructure.rest.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ErrorHandler  extends ResponseEntityExceptionHandler {

    private static final MediaType DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON;

    @ExceptionHandler(DateWrongFormatException.class)
    public ResponseEntity<ErrorDto> handleDateWrongFormatException(DateWrongFormatException ex, final WebRequest request) {
        log.error(":: handleDateWrongFormatException :: message: {}, type: {}", ex.getMessage(), ex.toString());
        ErrorDto error = new ErrorDto();
        error.setStatus(BAD_REQUEST.value());
        error.setError(BAD_REQUEST.getReasonPhrase());
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(getRequestURI(request));

        return ResponseEntity.status(BAD_REQUEST).contentType(DEFAULT_MEDIA_TYPE).body(error);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> exceptionHandler(RuntimeException ex, ServerWebExchange serverWebExchange) {
        log.error(":: exceptionHandler :: message: {}, type: {}", ex.getMessage(), ex.toString());

        ErrorDto error = new ErrorDto();
        error.setStatus(INTERNAL_SERVER_ERROR.value());
        error.setError(INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(serverWebExchange.getRequest().getPath().toString());

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).contentType(DEFAULT_MEDIA_TYPE).body(error);
    }


    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.error(":: handleMissingServletRequestParameter :: message: {}, type: {}", ex.getMessage(), ex.toString());
        ErrorDto error = new ErrorDto();
        error.setStatus(BAD_REQUEST.value());
        error.setError(BAD_REQUEST.getReasonPhrase());
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(getRequestURI(request));

        return ResponseEntity.status(BAD_REQUEST).contentType(DEFAULT_MEDIA_TYPE).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.error(":: handleTypeMismatch :: message: {}, type: {}", ex.getMessage(), ex.toString());
        ErrorDto error = new ErrorDto();
        error.setStatus(BAD_REQUEST.value());
        error.setError(BAD_REQUEST.getReasonPhrase());
        error.setMessage(ex.getMessage());
        error.setTimestamp(OffsetDateTime.now());
        error.setPath(getRequestURI(request));

        return ResponseEntity.status(BAD_REQUEST).contentType(DEFAULT_MEDIA_TYPE).body(error);
    }


    private String getRequestURI(WebRequest request) {
        return ((ServletWebRequest)request).getRequest().getRequestURI();
    }
}
