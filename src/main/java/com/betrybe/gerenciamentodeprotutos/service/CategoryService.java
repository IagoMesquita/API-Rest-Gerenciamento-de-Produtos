package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.entity.Category;
import com.betrybe.gerenciamentodeprotutos.exceptions.CategoryNotFound;
import com.betrybe.gerenciamentodeprotutos.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getCategoryById(Long categoryId) throws CategoryNotFound {
    return categoryRepository.findById(categoryId)
        .orElseThrow(CategoryNotFound::new);
  }

  public Category updateCategory(
      Long categoryId,
      Category category
  ) throws CategoryNotFound {
    Category categoryFromDb = categoryRepository.getReferenceById(categoryId);

    categoryFromDb.setName(category.getName());

    return categoryRepository.save(categoryFromDb);
  }

  public Category removeCategory(Long categoryId) throws CategoryNotFound{
    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(CategoryNotFound::new);
    categoryRepository.delete(category);

    return category;
  }
}
