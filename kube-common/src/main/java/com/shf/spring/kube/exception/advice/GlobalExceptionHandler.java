package com.shf.spring.kube.exception.advice;


import com.shf.spring.kube.exception.declaration.ResourceNotFoundException;
import com.shf.spring.kube.exception.entity.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Description:
 * Custom define global exception handlers
 *
 * @Author: songhaifeng
 * @Date: 2019/4/30 22:20
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorEntity errorEntity = new ErrorEntity(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorEntity errorEntity = new ErrorEntity(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}