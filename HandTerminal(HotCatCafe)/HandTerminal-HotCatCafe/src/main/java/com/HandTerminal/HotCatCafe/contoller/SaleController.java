package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.SaleDTO;
import com.HandTerminal.HotCatCafe.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SaleDTO> findSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.findSaleById(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<SaleDTO>> getSalesByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(saleService.getSalesByEmployeeId(employeeId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<SaleDTO> getSalesByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(saleService.getSalesByOrderId(orderId));
    }

    @PostMapping("/{orderId}&{employeeId}")
    public ResponseEntity<SaleDTO> insertSale(@PathVariable Long orderId, @PathVariable Long employeeId) {
        return ResponseEntity.ok(saleService.insertSale(orderId, employeeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.deleteSaleById(id));
    }
}
