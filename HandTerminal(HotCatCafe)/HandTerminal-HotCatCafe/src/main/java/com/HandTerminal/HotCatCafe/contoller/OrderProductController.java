package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.DTOs.OrderProductDTO;
import com.HandTerminal.HotCatCafe.requestModels.OrderProductRequestModel;
import com.HandTerminal.HotCatCafe.service.OrderProductService;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {
    @Autowired
    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public ResponseEntity<List<OrderProductDTO>> getAll() {
        return ResponseEntity.ok(orderProductService.getAllOrderProducts());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<OrderProductDTO>> getByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(orderProductService.getOrderProductsByProductId(productId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderProductDTO>> getByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderProductService.getOrderProductsByOrderId(orderId));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderProductService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insertOrderProduct(@RequestBody OrderProductRequestModel opVM) {
        return ResponseEntity.ok(orderProductService.insertOrderProduct(opVM));
    }
}
