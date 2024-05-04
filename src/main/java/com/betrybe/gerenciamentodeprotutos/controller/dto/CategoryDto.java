package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.Category;

public record CategoryDto(Long id, String name) {
  public static CategoryDto fromEntity(Category category) {
    return new CategoryDto(
        category.getId(),
        category.getName()
    );
  }
}
