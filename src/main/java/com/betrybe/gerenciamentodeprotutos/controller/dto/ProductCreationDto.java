package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.Product;

public record ProductCreationDto(String name, Double price) {
  public Product toEntity() {
    return new Product(
        name,
        price
    );

  }
}
