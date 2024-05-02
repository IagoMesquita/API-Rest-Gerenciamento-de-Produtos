package com.betrybe.gerenciamentodeprotutos.exceptions;

public class NotFoundException extends RuntimeException {
  NotFoundException(String message) {
     super(message);
  }
}
