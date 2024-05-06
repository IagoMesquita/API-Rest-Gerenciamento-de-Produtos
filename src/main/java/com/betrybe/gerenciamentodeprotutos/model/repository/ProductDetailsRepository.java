package com.betrybe.gerenciamentodeprotutos.model.repository;

import com.betrybe.gerenciamentodeprotutos.model.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetail, Long> {

}
