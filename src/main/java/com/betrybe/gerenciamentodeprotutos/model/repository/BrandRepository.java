package com.betrybe.gerenciamentodeprotutos.model.repository;

import com.betrybe.gerenciamentodeprotutos.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
