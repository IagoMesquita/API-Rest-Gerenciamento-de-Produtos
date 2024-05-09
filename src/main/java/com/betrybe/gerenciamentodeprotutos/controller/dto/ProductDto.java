package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.Product;
import java.util.List;

public record ProductDto(
    Long id,
    String name,
    Double price,
    ProductDetailsDto details,
    BrandDto brand,
    List<CategoryDto> categories) {

  public static ProductDto fromEntity(Product product) {
    BrandDto brandDto = product.getBrand() != null ?
        BrandDto.fromEntity(product.getBrand()) : null;

    ProductDetailsDto productDetailsDto = product.getProductDetail() != null ?
        ProductDetailsDto.fromEntity(product.getProductDetail()) : null;

    List<CategoryDto> categoryDto = product.getCategories().stream().map(CategoryDto::fromEntity)
        .toList();

    return new ProductDto(
        product.getId(),
        product.getName(),
        product.getPrice(),
        productDetailsDto,
        brandDto,
        categoryDto
        );
  }
}
