package com.HandTerminal.HotCatCafe.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.DTOs.OrderDTO;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class OrderService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/order";

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OrderDTO> getAllOrders() {
        String url = this.url + "/getAll";

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public OrderDTO findOrderById(Long id) {
        String url = this.url + "/byId=" + id;

        HttpEntity<OrderDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<OrderDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                OrderDTO.class);

        return response.getBody();
    }

    public List<OrderDTO> findByEmployeeId(Long employeeId) {
        String url = this.url + "/byEmploye?=" + employeeId;

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderDTO> findByTableNumber(String tableNumber) {
        String url = this.url + "/byTableNumber?=" + tableNumber;

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderDTO> findTotalPriceGreaterThan(BigDecimal price) {
        String url = this.url + "/greaterThan?price=" + price;

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderDTO> findTotalPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        String url = this.url + "/between?minPrice=" + minPrice + "&" + "maxPrice=" + maxPrice;

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public List<OrderDTO> findTotalPriceLessThan(BigDecimal price) {
        String url = this.url + "/lessThan?price=" + price;

        HttpEntity<List<OrderDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<OrderDTO>>() {
                });

        return response.getBody();
    }

    public Long insertOrder(String tableNumber, Long employeeId) {
        String url = this.url + "/insert?tableNumber=" + tableNumber + "&" + "employeeId=" + employeeId;

        HttpEntity<OrderDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                Long.class);

        return response.getBody();
    }

    public Long deleteById(Long id) {
        String url = this.url + "/delete?id=" + id;

        HttpEntity<OrderDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity,
                Long.class);

        return response.getBody();
    }
}
