package com.booklibrary.springboot.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ServiceException {

  public BadRequestException(String message, ServiceErrorCode serviceErrorCode) {
    super(message, HttpStatus.BAD_REQUEST, serviceErrorCode);
  }
}
