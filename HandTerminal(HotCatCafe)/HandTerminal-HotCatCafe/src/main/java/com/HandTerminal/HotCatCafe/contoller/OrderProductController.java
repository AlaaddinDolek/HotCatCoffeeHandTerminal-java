package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.DTOs.OrderProductDTO;
import com.HandTerminal.HotCatCafe.VMs.OrderProductVM;
import com.HandTerminal.HotCatCafe.service.OrderProductService;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {
    @Autowired
    private final OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderProductDTO>> getAll() {
        return ResponseEntity.ok(orderProductService.getAllOrderProducts());
    }

    @GetMapping("/getByProductId")
    public ResponseEntity<List<OrderProductDTO>> getByProductId(@RequestParam Long productId)   {
        return ResponseEntity.ok(orderProductService.getOrderProductsByProductId(productId));
    }

    @GetMapping("/getByOrderId")
    public ResponseEntity<List<OrderProductDTO>> getByOrderId(@RequestParam Long orderId)   {
        return ResponseEntity.ok(orderProductService.getOrderProductsByOrderId(orderId));
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long id) {
        orderProductService.deleteById(id);
    }

    @PostMapping("insert")
    public ResponseEntity<OrderDTO> insertOrderProduct(@RequestBody OrderProductVM opVM){
        return ResponseEntity.ok(orderProductService.insertOrderProduct(opVM));
    }
}
