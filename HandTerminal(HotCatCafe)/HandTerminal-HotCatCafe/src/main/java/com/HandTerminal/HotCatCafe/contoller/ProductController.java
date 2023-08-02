package com.HandTerminal.HotCatCafe.contoller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.ProductDTO;
import com.HandTerminal.HotCatCafe.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductDTO> findByProductName(@PathVariable String productName) {
        return ResponseEntity.ok(productService.findByProductName(productName));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> findByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }

    @GetMapping("/price/greater/{price}")
    public ResponseEntity<List<ProductDTO>> findTotalPriceGreaterThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(productService.findTotalPriceGreaterThan(price));
    }

    @GetMapping("/price/between/{minPrice}&{maxPrice}")
    public ResponseEntity<List<ProductDTO>> findTotalPriceBetween(@PathVariable BigDecimal minPrice,
            @PathVariable BigDecimal maxPrice) {
        return ResponseEntity.ok(productService.findTotalPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/price/less/{price}")
    public ResponseEntity<List<ProductDTO>> findTotalPriceLessThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(productService.findTotalPriceLessThan(price));
    }

    @GetMapping("/stock/less/{stock}")
    public ResponseEntity<List<ProductDTO>> findUnitInStockLessThan(@PathVariable Integer stock) {
        return ResponseEntity.ok(productService.findUnitInStockLessThan(stock));
    }

    @GetMapping("/stock/greater/{stock}")
    public ResponseEntity<List<ProductDTO>> findUnitInStockGreaterThan(@PathVariable Integer stock) {
        return ResponseEntity.ok(productService.findUnitInStockGreaterThan(stock));
    }

    @GetMapping("/stock/between/{minStock}&{maxStock}")
    public ResponseEntity<List<ProductDTO>> findUnitInStockBetween(@PathVariable Integer minStock,
            @PathVariable Integer maxStock) {
        return ResponseEntity.ok(productService.findUnitInStockBetween(minStock, maxStock));
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProducy(@RequestBody ProductDTO productDTO, @PathVariable Long productId) {
        return ResponseEntity.ok(productService.updateProduct(productDTO, productId));
    }
}
