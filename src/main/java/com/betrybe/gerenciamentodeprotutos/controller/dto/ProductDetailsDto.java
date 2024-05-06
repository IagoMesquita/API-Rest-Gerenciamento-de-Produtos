package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.ProductDetail;

public record ProductDetailsDto(Long id, Integer availableStock, Double unitPrice) {
  public static ProductDetailsDto fromEntity(ProductDetail productDetail) {
    return new ProductDetailsDto(
        productDetail.getId(),
        productDetail.getAvailableStock(),
        productDetail.getUnitPrice()
    );
  }
}
