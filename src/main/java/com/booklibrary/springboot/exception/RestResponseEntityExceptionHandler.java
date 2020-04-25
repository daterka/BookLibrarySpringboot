package com.booklibrary.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private Error createError(String message, ServiceErrorCode serviceErrorCode, HttpStatus status) {
    return new Error(message, serviceErrorCode, status);
  }

  @ExceptionHandler(value = {ServiceException.class})
  protected ResponseEntity<Object> handlerServiceException(RuntimeException rte, WebRequest request) {
    ServiceException ex = (ServiceException) rte;
    Error error = createError(ex.getMessage(), ex.getServiceErrorCode(), ex.getHttpStatus());
//    log.warn(error.toString());
    return handleExceptionInternal(rte, error, new HttpHeaders(), ex.getHttpStatus(), request);
  }

}
