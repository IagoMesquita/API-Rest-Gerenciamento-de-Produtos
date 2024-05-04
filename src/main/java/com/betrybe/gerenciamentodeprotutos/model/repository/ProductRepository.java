package com.betrybe.gerenciamentodeprotutos.model.repository;

import com.betrybe.gerenciamentodeprotutos.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
