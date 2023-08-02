package com.HandTerminal.HotCatCafe.contoller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/id/{orderId}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<OrderDTO>> findByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(orderService.findByEmployeeId(employeeId));
    }

    @GetMapping("/table/{tableNumber}")
    public ResponseEntity<List<OrderDTO>> findByTableNumber(@PathVariable String tableNumber) {
        return ResponseEntity.ok(orderService.findByTableNumber(tableNumber));
    }

    @GetMapping("/price/greater/{price}")
    public ResponseEntity<List<OrderDTO>> findTotalPriceGreaterThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(orderService.findTotalPriceGreaterThan(price));
    }

    @GetMapping("/price/between/{minPrice}&{maxPrice}")
    public ResponseEntity<List<OrderDTO>> findTotalPriceBetween(@PathVariable BigDecimal minPrice,
            @PathVariable BigDecimal maxPrice) {
        return ResponseEntity.ok(orderService.findTotalPriceBetween(minPrice, maxPrice));
    }

    @GetMapping("/price/less/{price}")
    public ResponseEntity<List<OrderDTO>> findTotalPriceLessThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(orderService.findTotalPriceLessThan(price));
    }

    @PostMapping("/{tableNumber}&{employeeId}")
    public ResponseEntity<Long> insertOrder(@PathVariable String tableNumber, @PathVariable Long employeeId) {
        return ResponseEntity.ok(orderService.insertOrder(tableNumber, employeeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.deleteById(orderId));
    }
}
