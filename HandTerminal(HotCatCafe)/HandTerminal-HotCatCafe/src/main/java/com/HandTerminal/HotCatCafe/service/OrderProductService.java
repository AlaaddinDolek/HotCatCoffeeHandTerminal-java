package com.HandTerminal.HotCatCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.DTOs.OrderProductDTO;
import com.HandTerminal.HotCatCafe.VMs.OrderProductVM;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class OrderProductService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/orderproduct";

    public OrderProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OrderProductDTO> getAllOrderProducts() {

        String url = this.url + "/getAll";

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderProductDTO> getOrderProductsByProductId(Long productId) {

        String url = this.url + "/getByProductId?productId=" + productId;

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderProductDTO> getOrderProductsByOrderId(Long orderId) {

        String url = this.url + "/getByProductId?orderId?=" + orderId;

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public void deleteById(Long id) {
        String url = this.url + "/deleteById?=" + id;

        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }

    public OrderDTO insertOrderProduct(OrderProductVM opVM) {

        String url = this.url + "/insert";

        HttpEntity<OrderProductVM> httpEntity = new HttpEntity<>(opVM, HeaderSetter.setHeader());

        ResponseEntity<OrderDTO> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, OrderDTO.class);

        return response.getBody();
    }

}
