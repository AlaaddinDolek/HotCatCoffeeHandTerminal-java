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
import com.HandTerminal.HotCatCafe.common.HeaderSetter;
import com.HandTerminal.HotCatCafe.requestModels.OrderProductRequestModel;

@Service
public class OrderProductService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/orderproduct";

    public OrderProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OrderProductDTO> getAllOrderProducts() {

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(this.url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderProductDTO> getOrderProductsByProductId(Long productId) {

        String url = this.url + "/product/" + productId;

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderProductDTO> getOrderProductsByOrderId(Long orderId) {

        String url = this.url + "/order/" + orderId;

        HttpEntity<List<OrderProductDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<OrderProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderProductDTO>>() {
                });

        return response.getBody();
    }

    public void deleteById(Long id) {
        String url = this.url + id;

        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }

    public OrderDTO insertOrderProduct(OrderProductRequestModel opRM) {


        HttpEntity<OrderProductRequestModel> httpEntity = new HttpEntity<>(opRM, HeaderSetter.setHeader());

        ResponseEntity<OrderDTO> response = restTemplate.exchange(this.url, HttpMethod.POST, httpEntity, OrderDTO.class);

        return response.getBody();
    }

}
