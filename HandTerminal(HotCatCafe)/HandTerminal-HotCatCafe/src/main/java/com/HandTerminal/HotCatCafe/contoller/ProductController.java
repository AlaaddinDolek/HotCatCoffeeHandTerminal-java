package com.HandTerminal.HotCatCafe.contoller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/byId")
    public ResponseEntity<ProductDTO> findById(@RequestParam Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/byProductName")
    public ResponseEntity<ProductDTO> findByProductName(@RequestParam String productName) {
        return ResponseEntity.ok(productService.findByProductName(productName));
    }

    @GetMapping("/byCategoryId")
    public ResponseEntity<List<ProductDTO>> findByCategoryId(@RequestParam Long categoryId) {
        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }

    @GetMapping("/priceGreater")
    public ResponseEntity<List<ProductDTO>> findTotalPriceGreaterThan(@RequestParam BigDecimal price) {
        return ResponseEntity.ok(productService.findTotalPriceGreaterThan(price));
    }

    @GetMapping("/priceBetween")
    public ResponseEntity<List<ProductDTO>> findTotalPriceBetween(@RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return ResponseEntity.ok(productService.findTotalPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/priceLess")
    public ResponseEntity<List<ProductDTO>> findTotalPriceLessThan(@RequestParam BigDecimal price) {
        return ResponseEntity.ok(productService.findTotalPriceLessThan(price));
    }

    @GetMapping("/stockLess")
    public ResponseEntity<List<ProductDTO>> findUnitInStockLessThan(@RequestParam Integer stock) {
        return ResponseEntity.ok(productService.findUnitInStockLessThan(stock));
    }

    @GetMapping("/stockGreater")
    public ResponseEntity<List<ProductDTO>> findUnitInStockGreaterThan(@RequestParam Integer stock) {
        return ResponseEntity.ok(productService.findUnitInStockGreaterThan(stock));
    }

    @GetMapping("/stockBetween")
    public ResponseEntity<List<ProductDTO>> findUnitInStockBetween(@RequestParam Integer minStock,
            @RequestParam Integer maxStock) {
        return ResponseEntity.ok(productService.findUnitInStockBetween(minStock, maxStock));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

        @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProducy(@RequestBody ProductDTO productDTO, @RequestParam Long productId) {
        return ResponseEntity.ok(productService.updateProduct(productDTO,productId));
    }
}
