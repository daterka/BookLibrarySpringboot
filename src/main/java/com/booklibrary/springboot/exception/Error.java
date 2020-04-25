package com.booklibrary.springboot.exception;
import org.springframework.http.HttpStatus;

public class Error {
  private String message;
  private ServiceErrorCode error;
  private HttpStatus status;

  public Error(String message, ServiceErrorCode serviceErrorCode, HttpStatus status) {
    this.message = message;
    this.error = serviceErrorCode;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ServiceErrorCode getError() {
    return error;
  }

  public void setError(ServiceErrorCode error) {
    this.error = error;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Error{" +
            "message='" + message + '\'' +
            ", error=" + error +
            ", status=" + status +
            '}';
  }
}
