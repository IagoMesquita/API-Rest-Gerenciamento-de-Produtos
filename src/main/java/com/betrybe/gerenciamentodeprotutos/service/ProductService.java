package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductCreationDto;
import com.betrybe.gerenciamentodeprotutos.entity.Product;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
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

  public Product findProductById(Long productId)
      throws ProductNotFoundException {

    return productRepository.findById(productId)
        .orElseThrow(ProductNotFoundException::new);
  }

  public Product updateProduct(Long productId, Product product)
      throws ProductNotFoundException {
    Product productFromDb = productRepository.findById(productId)
        .orElseThrow(ProductNotFoundException::new);

    productFromDb.setName(
        product.getName()
    );
    productFromDb.setPrice(
        product.getPrice()
    );

    return productRepository.save(product);

  }

  public Product removeProduct(Long productId)
  throws ProductNotFoundException {
    Product product = productRepository.findById(productId)
        .orElseThrow(ProductNotFoundException::new);

    productRepository.delete(product);

    return product;
  }


}
