package com.betrybe.gerenciamentodeprotutos.controller;

import com.betrybe.gerenciamentodeprotutos.controller.dto.BrandCreationDto;
import com.betrybe.gerenciamentodeprotutos.controller.dto.BrandDto;
import com.betrybe.gerenciamentodeprotutos.model.entity.Brand;
import com.betrybe.gerenciamentodeprotutos.exceptions.BrandNotFoundException;
import com.betrybe.gerenciamentodeprotutos.service.BrandService;
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
@RequestMapping("/brands")
public class BrandController {

  private final BrandService brandService;

  @Autowired
  public BrandController(BrandService brandService) {
    this.brandService = brandService;
  }

  @PostMapping
  public ResponseEntity<BrandDto> createBrand(
      @RequestBody BrandCreationDto brandCreationDto) {

    Brand brand = brandCreationDto.toEntity();
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            BrandDto.fromEntity(brandService.createBrand(brand))
        );

  }

  @GetMapping
  public ResponseEntity<List<BrandDto>> getAllBrands() {
    return ResponseEntity.ok().body(
        brandService.getAllBrands()
            .stream()
            .map(BrandDto::fromEntity).toList()
    );
  }


  @GetMapping("/{brandId}")
  public ResponseEntity<BrandDto> getBrandById(@PathVariable Long brandId)
      throws BrandNotFoundException {
    return ResponseEntity.ok()
        .body(
            BrandDto.fromEntity(
                brandService.getBrandById(brandId)
            )
        );
  }

  @PutMapping("/{brandId}")
  public ResponseEntity<BrandDto> updateBrand(
      @PathVariable Long brandId,
      @RequestBody BrandCreationDto brandCreationDto
  ) throws BrandNotFoundException {
    Brand brand = brandCreationDto.toEntity();

    return ResponseEntity.ok()
        .body(
            BrandDto.fromEntity(
                brandService.updateBrand(brandId, brand)
            )
        );
  }

  @DeleteMapping("/{brandId}")
  public ResponseEntity<BrandDto> removeBrand(@PathVariable Long brandId)
      throws BrandNotFoundException {
    return ResponseEntity.ok().body(
        BrandDto.fromEntity(brandService.removeBrand(brandId))
    );
  }

}
