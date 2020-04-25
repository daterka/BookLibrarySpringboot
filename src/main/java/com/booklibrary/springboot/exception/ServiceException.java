package com.booklibrary.springboot.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

  private final HttpStatus httpStatus;
  private final ServiceErrorCode serviceErrorCode;

  public ServiceException(String message, HttpStatus httpStatus, ServiceErrorCode serviceErrorCode) {
    super(message);
    this.httpStatus = httpStatus;
    this.serviceErrorCode = serviceErrorCode;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ServiceErrorCode getServiceErrorCode() {
    return serviceErrorCode;
  }

//  @Override
//  public String getMessage() {
//    return String.format("Exception message: {%s}, http status code: {%s}, error code: {%s}",
//        super.getMessage(),
//        httpStatus.toString(), serviceErrorCode.name());
//  }
}
