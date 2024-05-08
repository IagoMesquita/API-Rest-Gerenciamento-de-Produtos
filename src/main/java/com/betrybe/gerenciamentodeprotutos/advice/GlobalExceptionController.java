package com.betrybe.gerenciamentodeprotutos.advice;

import com.betrybe.gerenciamentodeprotutos.exceptions.BrandNotFoundException;
import com.betrybe.gerenciamentodeprotutos.exceptions.CategoryNotFound;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductDetailsNotFoundException;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionController {

  @ExceptionHandler({
      ProductNotFoundException.class,
      ProductDetailsNotFoundException.class,
      BrandNotFoundException.class,
      CategoryNotFound.class
  })
  public ResponseEntity<String> handleNotFoundExceptions(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundRote(NoHandlerFoundException exception) {
    return "Página não encontrada ou não existe.";
  }
}
