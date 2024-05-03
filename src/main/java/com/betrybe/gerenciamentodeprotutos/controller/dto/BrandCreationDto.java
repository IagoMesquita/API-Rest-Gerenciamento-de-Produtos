package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.entity.Brand;

public record BrandCreationDto(String name) {
  public Brand toEntity() {
    return new Brand(
        name
    );
  }
}
