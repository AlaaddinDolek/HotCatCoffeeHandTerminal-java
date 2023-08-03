package com.HandTerminal.HotCatCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.common.HeaderSetter;
import com.HandTerminal.HotCatCafe.DTOs.SaleDTO;

@Service
public class SaleService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/sale";

    public SaleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SaleDTO> getAllSales() {

        HttpEntity<List<SaleDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<SaleDTO>> response = restTemplate.exchange(this.url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<SaleDTO>>() {
                });
        return response.getBody();

    }

    public SaleDTO findSaleById(Long id) {
        String url = this.url + "/byId?id=" + id;
        return restTemplate.getForObject(url, SaleDTO.class);
    }

    public List<SaleDTO> getSalesByEmployeeId(Long employeeId) {
        String url = this.url + "/employee/" + employeeId;
        HttpEntity<List<SaleDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());
        ResponseEntity<List<SaleDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<SaleDTO>>() {
                });
        return response.getBody();
    }

    public SaleDTO getSalesByOrderId(Long orderId) {
        String url = this.url + "/order/" + orderId;
        return restTemplate.getForObject(url, SaleDTO.class);
    }

    public SaleDTO insertSale(Long orderId, Long employeeId) {
        String url = this.url + orderId + "&" + employeeId;

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("orderId", String.valueOf(orderId));
        requestMap.add("employeeId", String.valueOf(employeeId));

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(requestMap, HeaderSetter.setHeader());
        ResponseEntity<SaleDTO> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, SaleDTO.class);
        return response.getBody();
    }

    public Long deleteSaleById(Long id) {
        String url = this.url + id;
        return restTemplate.exchange(url, HttpMethod.DELETE, null, Long.class).getBody();
    }
}
