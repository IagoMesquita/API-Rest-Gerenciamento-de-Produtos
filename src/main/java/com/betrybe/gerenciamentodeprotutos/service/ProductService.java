package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.exceptions.ProductDetailsNotFoundException;
import com.betrybe.gerenciamentodeprotutos.model.entity.Product;
import com.betrybe.gerenciamentodeprotutos.exceptions.ProductNotFoundException;
import com.betrybe.gerenciamentodeprotutos.model.entity.ProductDetail;
import com.betrybe.gerenciamentodeprotutos.model.repository.ProductDetailsRepository;
import com.betrybe.gerenciamentodeprotutos.model.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductDetailsRepository productDetailRepository;

  @Autowired
  public ProductService(
      ProductRepository productRepository,
      ProductDetailsRepository productDetailRepository) {
    this.productRepository = productRepository;
    this.productDetailRepository = productDetailRepository;
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

  public ProductDetail createProductDetail(Long productId, ProductDetail productDetail)
      throws ProductNotFoundException {
    Product productFromDb = findProductById(productId);

    productFromDb.setProductDetail(productDetail);

    return productDetailRepository.save(productDetail);
  }

  public ProductDetail getProductDetail(Long productId)
      throws ProductNotFoundException, ProductDetailsNotFoundException {
    Product productFromDb = findProductById(productId);

   ProductDetail productDetail = productFromDb.getProductDetail();

   if (productDetail == null) {
     throw new ProductDetailsNotFoundException();
   }

   return productDetail;
  }

  public ProductDetail updateProductDetail(Long productId, ProductDetail productDetail)
      throws ProductNotFoundException, ProductDetailsNotFoundException {
      Product productFromDb = findProductById(productId);

      ProductDetail productDetailFromDb = productFromDb.getProductDetail();

      if (productDetail == null) {
        throw  new ProductDetailsNotFoundException();
      }

      productDetailFromDb.setProduct(productDetail.getProduct());
      productDetailFromDb.setUnitPrice(productDetail.getUnitPrice());
      productDetailFromDb.setAvailableStock(productDetail.getAvailableStock());

      return productDetailRepository.save(productDetailFromDb);
  }

  public ProductDetail removeProductDetail(Long productId)
      throws ProductNotFoundException, ProductDetailsNotFoundException {
    Product productFromDb = findProductById(productId);

    ProductDetail productDetailFromDb = productFromDb.getProductDetail();

    if (productDetailFromDb == null) {
      throw new ProductDetailsNotFoundException();
    }

    //Quebrar relacionamento antes de deletar
    productFromDb.setProductDetail(null);
    productDetailFromDb.setProduct(null);

    productDetailRepository.delete(productDetailFromDb);

    return productDetailFromDb;
  }


}
