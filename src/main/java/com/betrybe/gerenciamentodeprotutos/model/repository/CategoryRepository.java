package com.betrybe.gerenciamentodeprotutos.model.repository;

import com.betrybe.gerenciamentodeprotutos.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
