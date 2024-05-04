package com.betrybe.gerenciamentodeprotutos.controller;

import com.betrybe.gerenciamentodeprotutos.controller.dto.CategoryCreationDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.CategoryDto;
import com.betrybe.gerenciamentodeprotutos.exceptions.CategoryNotFound;
import com.betrybe.gerenciamentodeprotutos.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping
  public ResponseEntity<CategoryDto> createCategory(
      @RequestBody CategoryCreationDto categoryCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(
        CategoryDto.fromEntity(
            categoryService.createCategory(categoryCreationDto.toEntity())
        )
    );
  }

  @GetMapping
  public ResponseEntity<List<CategoryDto>> getAllCategories() {
    return ResponseEntity.ok().body(
        categoryService.getAllCategories().stream()
            .map(CategoryDto::fromEntity).toList()
    );
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long categoryId)
      throws CategoryNotFound {
    return ResponseEntity.ok()
        .body(CategoryDto.fromEntity(
            categoryService.getCategoryById(categoryId)
        ));
  }


  @PutMapping("/{categoryId}")
  public ResponseEntity<CategoryDto> updateCategory(
      @PathVariable Long categoryId,
      @RequestBody CategoryCreationDto categoryCreationDto
  ) throws CategoryNotFound {
    return ResponseEntity.ok().body(
        CategoryDto.fromEntity(
            categoryService.updateCategory(categoryId, categoryCreationDto.toEntity())
        )

    );
  }

  @DeleteMapping("/{categoryId}")
  public ResponseEntity<CategoryDto> removeCategory(@PathVariable Long categoryId)
      throws CategoryNotFound {
    return ResponseEntity.ok().body(
        CategoryDto.fromEntity(
            categoryService.removeCategory(categoryId)
        )
    );
  }
}
