package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/byId")
    public ResponseEntity<SaleDTO> findSaleById(@RequestParam Long id) {
        return ResponseEntity.ok(saleService.findSaleById(id));
    }

    @GetMapping("/byEmployeeId")
    public ResponseEntity<List<SaleDTO>> getSalesByEmployeeId(@RequestParam Long employeeId) {
        return ResponseEntity.ok(saleService.getSalesByEmployeeId(employeeId));
    }

    @GetMapping("/byOrderId")
    public ResponseEntity<SaleDTO> getSalesByOrderId(@RequestParam Long orderId) {
        return ResponseEntity.ok(saleService.getSalesByOrderId(orderId));
    }

    @PostMapping("/insert")
    public ResponseEntity<SaleDTO> insertSale(@RequestParam Long orderId, @RequestParam Long employeeId) {
        return ResponseEntity.ok(saleService.insertSale(orderId, employeeId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteSaleById(@RequestParam Long id) {
        return ResponseEntity.ok(saleService.deleteSaleById(id));
    }
}
