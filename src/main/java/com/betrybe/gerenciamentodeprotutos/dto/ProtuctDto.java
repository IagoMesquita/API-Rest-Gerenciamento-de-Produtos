package com.betrybe.gerenciamentodeprotutos.dto;

import com.betrybe.gerenciamentodeprotutos.entity.Product;

public record ProtuctDto(Long id, String name, Double price) {
  public static ProtuctDto fromEntity(Product product) {
    return new ProtuctDto(
        product.getId(),
        product.getName(),
        product.getPrice()
    );
  }
}
