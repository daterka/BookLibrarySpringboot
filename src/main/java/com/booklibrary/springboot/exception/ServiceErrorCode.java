package com.booklibrary.springboot.exception;

public enum ServiceErrorCode {
  CONNECTION_FAILED(1),
  BAD_REQUEST(2),
  BOOK_NOT_FOUND(3),
  BOOK_ALREADY_EXISTED(4),
  USER_NOT_FOUND(5),
  USER_ALREADY_EXISTED(6);

  private final int code;

  ServiceErrorCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
