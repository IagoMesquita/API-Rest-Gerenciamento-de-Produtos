package com.betrybe.gerenciamentodeprotutos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer availableStock;
  private Double unitPrice;

  @OneToOne(optional = false)
  @JoinColumn(name = "product_id")
  private Product product;

  public ProductDetail() {
  }

  public ProductDetail(Integer availableStock, Double unitPrice) {
    this.availableStock = availableStock;
    this.unitPrice = unitPrice;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getAvailableStock() {
    return availableStock;
  }

  public void setAvailableStock(Integer availableStock) {
    this.availableStock = availableStock;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
