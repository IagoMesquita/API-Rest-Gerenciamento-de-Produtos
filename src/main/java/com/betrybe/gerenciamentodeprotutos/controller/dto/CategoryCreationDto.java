package com.betrybe.gerenciamentodeprotutos.controller.dto;

import com.betrybe.gerenciamentodeprotutos.model.entity.Category;

public record CategoryCreationDto(String name) {
  public Category toEntity() {
    return new Category(
        name
    ) ;
  }
}
