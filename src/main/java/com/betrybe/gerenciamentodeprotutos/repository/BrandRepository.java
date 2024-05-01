package com.betrybe.gerenciamentodeprotutos.repository;

import com.betrybe.gerenciamentodeprotutos.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
