package com.betrybe.gerenciamentodeprotutos.exceptions;

public class ProductDetailsNotFoundException extends NotFoundException {

  public ProductDetailsNotFoundException() {
    super("Detalhes do produto não encontrado!");
  }
}
