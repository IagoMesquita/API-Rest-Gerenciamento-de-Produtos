package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.Brand;

public record BrandDto(Long id, String name) {
  public static BrandDto fromEntity(Brand brand) {
    return new BrandDto(
        brand.getId(),
        brand.getName()
    );
  }

}
