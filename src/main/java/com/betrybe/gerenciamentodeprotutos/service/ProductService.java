package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.entity.Product;
import com.betrybe.gerenciamentodeprotutos.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(Product newProduct) {
    return productRepository.save(newProduct);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}
