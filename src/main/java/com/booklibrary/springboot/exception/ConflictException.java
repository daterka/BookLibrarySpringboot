package com.booklibrary.springboot.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ServiceException {

  public ConflictException(String message,
      ServiceErrorCode serviceErrorCode) {
    super(message, HttpStatus.CONFLICT, serviceErrorCode);
  }
}
