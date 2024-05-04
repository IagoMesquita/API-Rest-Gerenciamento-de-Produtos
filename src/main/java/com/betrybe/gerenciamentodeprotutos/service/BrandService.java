package com.betrybe.gerenciamentodeprotutos.service;

import com.betrybe.gerenciamentodeprotutos.entity.Brand;
import com.betrybe.gerenciamentodeprotutos.exceptions.BrandNotFoundException;
import com.betrybe.gerenciamentodeprotutos.repository.BrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BrandService {

  private final BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  public Brand createBrand(Brand newBrand) {
    return brandRepository.save(newBrand);
  }

  public List<Brand> getAllBrands() {
    return brandRepository.findAll();
  }

  public Brand getBrandById(Long brandId) throws BrandNotFoundException {
    return brandRepository.findById(brandId)
        .orElseThrow(BrandNotFoundException::new);
  }

  public Brand updateBrand(Long brandId, Brand brand) throws BrandNotFoundException {
    Brand brandFromDb = brandRepository.findById(brandId)
        .orElseThrow(BrandNotFoundException::new);
    brandFromDb.setName(brand.getName());
    return  brandRepository.save(brandFromDb);
  }

  public Brand removeBrand(Long brandId) throws BrandNotFoundException{
    Brand brandFromDb = brandRepository.findById(brandId)
        .orElseThrow(BrandNotFoundException::new);
    brandRepository.delete(brandFromDb);
    return brandFromDb;
  }

}
