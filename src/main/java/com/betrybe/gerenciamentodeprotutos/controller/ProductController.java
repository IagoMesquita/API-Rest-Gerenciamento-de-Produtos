package com.betrybe.gerenciamentodeprotutos.controller;

import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductCreationDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductDto;
import com.betrybe.gerenciamentodeprotutos.entity.Product;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
import com.betrybe.gerenciamentodeprotutos.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreationDto productCreationDto) {
    Product product = productCreationDto.toEntity();
    return ResponseEntity.status(HttpStatus.CREATED).body(
        ProductDto
            .fromEntity(productService.createProduct(product))
    );
  }

  @GetMapping
  public ResponseEntity<List<ProductDto>> findAllProduct() {
    return ResponseEntity.ok().body(
        productService.getAllProducts()
            .stream()
            .map(ProductDto::fromEntity)
            .toList()
    );
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId)
      throws ProductNotFoundException {
    return ResponseEntity.ok().body(
        ProductDto.fromEntity(productService.findProductById(productId))
    );
  }

//  @ExceptionHandler
//  public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception) {
//    return ResponseEntity
//        .status(HttpStatus.NOT_FOUND)
//        .body(exception.getMessage());
//  }

  @PutMapping("/{productId}")
  public ResponseEntity<ProductDto> updateProduct(
      @PathVariable Long productId,
      @RequestBody ProductCreationDto productCreationDto
  ) throws ProductNotFoundException {
    Product product = productCreationDto.toEntity();

    return ResponseEntity.ok().body(
        ProductDto.fromEntity(productService.updateProduct(productId, product))
    );
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<ProductDto> removeProduct(Long productId) throws ProductNotFoundException {
    return ResponseEntity.ok().body(
        ProductDto.fromEntity(productService.removeProduct(productId))
    );
  }
}
