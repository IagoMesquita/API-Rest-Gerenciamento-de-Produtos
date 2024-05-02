package com.betrybe.gerenciamentodeprotutos.advice;

import com.betrybe.gerenciamentodeprotutos.exceptions.BrandNotFoundException;
import com.betrybe.gerenciamentodeprotutos.exceptions.CategoryNotFound;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

  @ExceptionHandler({
    ProductNotFoundException.class,
    BrandNotFoundException.class,
    CategoryNotFound.class
  })
  public ResponseEntity<String> handleNotFoundExceptions(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }
}
