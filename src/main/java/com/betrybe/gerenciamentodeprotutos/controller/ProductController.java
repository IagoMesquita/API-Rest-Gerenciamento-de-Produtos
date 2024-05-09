package com.betrybe.gerenciamentodeprotutos.controller;

import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductCreationDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductDetailsCreatingDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductDetailsDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.ProductDto;
import com.betrybe.gerenciamentodeprotutos.exceptions.BrandNotFoundException;
import com.betrybe.gerenciamentodeprotutos.exceptions.CategoryNotFound;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductDetailsNotFoundException;
import com.betrybe.gerenciamentodeprotutos.model.entity.Product;
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
import org.springframework.web.bind.annotation.ResponseStatus;
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
  public ResponseEntity<ProductDto> createProduct(
      @RequestBody ProductCreationDto productCreationDto) {
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

  // Details OneToOne Products
  @PostMapping("/{productId}/details")
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDetailsDto createProductDetail(
      @PathVariable Long productId,
      @RequestBody ProductDetailsCreatingDto productDetailsCreatingDto)
      throws ProductNotFoundException {

    return ProductDetailsDto.fromEntity(
        productService.createProductDetail(productId, productDetailsCreatingDto.toEntity())
    );
  }

  @GetMapping("/{productId}/details")
  @ResponseStatus(HttpStatus.OK)
  public ProductDetailsDto getProductDetail(@PathVariable Long productId)
      throws ProductDetailsNotFoundException, ProductNotFoundException {
    return ProductDetailsDto.fromEntity(productService.getProductDetail(productId));
  }

  @PutMapping("/{productId}/details")
  @ResponseStatus(HttpStatus.OK)
  public ProductDetailsDto updateProductDetail(
      @PathVariable Long productId,
      @RequestBody ProductDetailsCreatingDto productDetailsCreatingDto)
      throws ProductDetailsNotFoundException, ProductNotFoundException {
    return ProductDetailsDto.fromEntity(
        productService.updateProductDetail(productId, productDetailsCreatingDto.toEntity())
    );
  }

  @DeleteMapping("/{productId}/details")
  @ResponseStatus(HttpStatus.OK)
  public ProductDetailsDto removeProductDetail(@PathVariable Long productId)
      throws ProductNotFoundException, ProductDetailsNotFoundException {
    return ProductDetailsDto.fromEntity(productService.removeProductDetail(productId));
  }

  // Brand OneToMany Products
  @PutMapping("/{productId}/brands/{brandId}")
  @ResponseStatus(HttpStatus.OK)
  public ProductDto setProductBrand(
      @PathVariable Long productId,
      @PathVariable Long brandId) throws ProductNotFoundException, BrandNotFoundException {
    return ProductDto.fromEntity(productService.setProductBrand(productId, brandId));
  }

  @DeleteMapping("/{productId}/brands")
  @ResponseStatus(HttpStatus.OK)
  private ProductDto removeProductBrand(@PathVariable Long productId)
      throws ProductNotFoundException {
    return ProductDto.fromEntity(productService.removeProductBrand(productId));
  }

  @PutMapping("/{productId}/categories/{categoryId}")
  public ResponseEntity<ProductDto> setProductCategory(
      @PathVariable Long productId,
      @PathVariable Long categoryId) throws ProductNotFoundException, CategoryNotFound {

    return ResponseEntity.ok().body(
        ProductDto.fromEntity(
            productService.setProductCategory(productId, categoryId)
        )
    );
  }

  @DeleteMapping("/{productId}/categories/{categoryId}")
  public ResponseEntity<ProductDto> removeProductCategory(
      @PathVariable Long productId,
      @PathVariable Long categoryId) throws ProductNotFoundException, CategoryNotFound {
    return ResponseEntity.ok().body(
        ProductDto.fromEntity(
            productService.removeProductCategory(productId, categoryId)
        )
    );
  }

}
