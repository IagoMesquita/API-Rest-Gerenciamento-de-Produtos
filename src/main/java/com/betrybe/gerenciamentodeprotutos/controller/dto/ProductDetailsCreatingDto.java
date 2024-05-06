package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.ProductDetail;

public record ProductDetailsCreatingDto(Integer availableStock, Double unitPrice) {
  public ProductDetail toEntity() {
    return new ProductDetail(
        availableStock,
        unitPrice
    );
  }
}
