package com.betrybe.gerenciamentodeprotutos.exceptions;

public class ProductNotFoundException extends Exception {

  public ProductNotFoundException() {
    super("Produto não encontrado!");
  }
}
