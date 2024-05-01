package com.betrybe.gerenciamentodeprotutos.repository;

import com.betrybe.gerenciamentodeprotutos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
