package com.HandTerminal.HotCatCafe.contoller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.service.OrderService;

public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/byId")
    public ResponseEntity<OrderDTO> findOrderById(@RequestParam Long orderId) {
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }

    @GetMapping("/byEmployeeId")
    public ResponseEntity<List<OrderDTO>> findByEmployeeId(@RequestParam Long employeeId) {
        return ResponseEntity.ok(orderService.findByEmployeeId(employeeId));
    }

    @GetMapping("/byTableNumber")
    public ResponseEntity<List<OrderDTO>> findByTableNumber(@RequestParam String tableNumber) {
        return ResponseEntity.ok(orderService.findByTableNumber(tableNumber));
    }

    @GetMapping("/greaterThan")
    public ResponseEntity<List<OrderDTO>> findTotalPriceGreaterThan(@RequestParam BigDecimal price) {
        return ResponseEntity.ok(orderService.findTotalPriceGreaterThan(price));
    }

    @GetMapping("/between")
    public ResponseEntity<List<OrderDTO>> findTotalPriceBetween(@RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        return ResponseEntity.ok(orderService.findTotalPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/lessThan")
    public ResponseEntity<List<OrderDTO>> findTotalPriceLessThan(@RequestParam BigDecimal price) {
        return ResponseEntity.ok(orderService.findTotalPriceLessThan(price));
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insertOrder(@RequestParam String tableNumber, @RequestParam Long employeeId) {
        return ResponseEntity.ok(orderService.insertOrder(tableNumber, employeeId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteOrderById(@RequestParam Long orderId) {
        return ResponseEntity.ok(orderService.deleteById(orderId));
    }
}
