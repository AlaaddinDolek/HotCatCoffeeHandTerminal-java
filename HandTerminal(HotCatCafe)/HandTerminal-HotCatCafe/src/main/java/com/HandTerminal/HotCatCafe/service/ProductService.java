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

import com.HandTerminal.HotCatCafe.DTOs.ProductDTO;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class ProductService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/product";

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDTO> getAllProducts() {

        String url = this.url + "/getAll";

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public ProductDTO findById(Long id) {

        String url = this.url + "/byId?=" + id;
        ProductDTO response = restTemplate.getForObject(url, ProductDTO.class);
        return response;
    }

    public ProductDTO findByProductName(String productName) {
        String url = this.url + "/byProductName?=" + productName;
        ProductDTO response = restTemplate.getForObject(url, ProductDTO.class);
        return response;
    }

    public List<ProductDTO> findByCategoryId(Long categoryId) {
        String url = this.url + "/byCategoryId?=" + categoryId;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findTotalPriceGreaterThan(BigDecimal price) {
        String url = this.url + "/price?=" + price;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findTotalPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        String url = this.url + "/priceBetween?minPrice=" + minPrice + "&" + "maxPrice=" + maxPrice;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findTotalPriceLessThan(BigDecimal price) {

        String url = this.url + "/priceLess?price=" + price;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findUnitInStockLessThan(Integer stock) {
        String url = this.url + "/stockLess?stock=" + stock;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findUnitInStockGreaterThan(Integer stock) {

        String url = this.url + "/stockGreater?stock=" + stock;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public List<ProductDTO> findUnitInStockBetween(Integer minStock, Integer maxStock) {

        String url = this.url + "/stockBetween?minStock=" + minStock + "&" + "maxStock=" + maxStock;

        List<ProductDTO> response = restTemplate.getForObject(url, null,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response;
    }

    public Long addProduct(ProductDTO productDTO) {
        String url = this.url + "/add";
        HttpEntity<ProductDTO> httpEntity = new HttpEntity<ProductDTO>(productDTO, HeaderSetter.setHeader());
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Long.class);
        return response.getBody();
    }

    public ProductDTO updateProduct(ProductDTO productDTO, Long id) {
          String url = this.url + "/update?productId="+id;
        HttpEntity<ProductDTO> httpEntity = new HttpEntity<>(productDTO, HeaderSetter.setHeader());
        ResponseEntity<ProductDTO> response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, ProductDTO.class);

        return response.getBody();
    }
}
