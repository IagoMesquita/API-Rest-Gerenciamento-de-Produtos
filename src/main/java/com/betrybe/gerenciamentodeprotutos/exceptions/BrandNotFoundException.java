package com.betrybe.gerenciamentodeprotutos.exceptions;

public class BrandNotFoundException extends NotFoundException {
  public  BrandNotFoundException() {
    super("Marca não encontrada!");
  }
}
