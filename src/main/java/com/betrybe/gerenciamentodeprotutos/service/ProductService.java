package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.dto.ProductCreationDto;
import com.betrybe.gerenciamentodeprotutos.entity.Product;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
import com.betrybe.gerenciamentodeprotutos.repository.ProductRepository;
import java.security.ProtectionDomain;
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

  public Product findProductById(Long productId)
      throws ProductNotFoundException {

    return productRepository.findById(productId)
        .orElseThrow(ProductNotFoundException::new);
  }

  public Product updateProduct(Long productId, ProductCreationDto productCreationDto)
      throws ProductNotFoundException {
    Product product = productRepository.findById(productId)
        .orElseThrow(ProductNotFoundException::new);

    product.setName(
        productCreationDto.name()
    );
    product.setPrice(
        productCreationDto.price()
    );

    return productRepository.save(product);

  }


}
