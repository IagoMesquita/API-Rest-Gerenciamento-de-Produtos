package com.betrybe.gerenciamentodeprotutos.dto;

public record ProductCreationDto(String name, Double price) {
  public ProductCreationDto toEntity() {
    return new ProductCreationDto(name, price);
  }
}
