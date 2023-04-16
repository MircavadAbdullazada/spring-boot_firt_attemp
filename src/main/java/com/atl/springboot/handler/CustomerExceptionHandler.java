package com.atl.springboot.handler;


import com.atl.springboot.entity.ErrorResponse;
import com.atl.springboot.exception.CustomerExistsException;
import com.atl.springboot.exception.NoSuchCustomerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object>  handleExceptions(Exception e, WebRequest webRequest){
        return buildErrorResponse(e,webRequest);
    }

    private ResponseEntity<Object> buildErrorResponse (Exception e,WebRequest webRequest){
        if(e instanceof CustomerExistsException ){
            return getResponseEntity(e,HttpStatus.CONFLICT,webRequest,e.getMessage());
        } else if (e instanceof NoSuchCustomerException) {
            return getResponseEntity(e,HttpStatus.NO_CONTENT,webRequest,e.getMessage());
        }else return getResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR,webRequest,e.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status,WebRequest webRequest) {
        return super.handleMethodArgumentNotValid(e,headers,status,webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }

    private ResponseEntity<Object> getResponseEntity( Exception e, HttpStatus status, WebRequest request, String message){
        ErrorResponse response= ErrorResponse.builder()
                .message(message)
                .localDateTime(LocalDateTime.now())
                .statusCode(status.value())
                .build();
        return new ResponseEntity<>(response,status);
    }

}
