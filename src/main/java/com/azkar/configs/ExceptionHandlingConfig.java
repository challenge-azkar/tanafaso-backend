package com.azkar.configs;

import com.azkar.payload.ResponseBase.Error;
import com.azkar.payload.exceptions.BadRequestException;
import com.azkar.payload.exceptions.DefaultExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingConfig {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingConfig.class);

  @ExceptionHandler
  public ResponseEntity<DefaultExceptionResponse> handleException(Exception e) {
    DefaultExceptionResponse response = new DefaultExceptionResponse();
    if (e instanceof BadRequestException) {
      response.setError(((BadRequestException) e).error);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    } else {
      logger.error(e.getMessage(), e);
      response.setError(new Error(Error.DEFAULT_ERROR));
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }
}
