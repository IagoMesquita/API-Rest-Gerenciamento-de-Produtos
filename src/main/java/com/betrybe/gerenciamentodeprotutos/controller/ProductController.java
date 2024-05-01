package com.betrybe.gerenciamentodeprotutos.controller;

import com.betrybe.gerenciamentodeprotutos.entity.Product;
import com.betrybe.gerenciamentodeprotutos.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping()
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return ResponseEntity.status(HttpStatus.CREATED).body(
        productService.createProduct(product)
    );
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAllProduct() {
    return ResponseEntity.ok().body(
        productService.getAllProducts()
    );
  }


}
