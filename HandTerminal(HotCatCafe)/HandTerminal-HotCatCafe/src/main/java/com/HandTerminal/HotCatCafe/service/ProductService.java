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

import com.HandTerminal.HotCatCafe.common.HeaderSetter;
import com.HandTerminal.HotCatCafe.DTOs.ProductDTO;


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

           HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public ProductDTO findById(Long id) {
        String url = this.url + "/byId?id=" + id;
        ProductDTO response = restTemplate.getForObject(url, ProductDTO.class);
        return response;
    }

    public ProductDTO findByProductName(String productName) {
        String url = this.url + "/byProductName?productName=" + productName;
        ProductDTO response = restTemplate.getForObject(url, ProductDTO.class);
        return response;
    }

    public List<ProductDTO> findByCategoryId(Long categoryId) {
        String url = this.url + "/byCategoryId?categoryId=" + categoryId;
        HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findTotalPriceGreaterThan(BigDecimal price) {
        String url = this.url + "/priceGreater?price=" + price;

        HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findTotalPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        String url = this.url + "/priceBetween?minPrice=" + minPrice + "&" + "maxPrice=" + maxPrice;

         HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findTotalPriceLessThan(BigDecimal price) {

        String url = this.url + "/priceLess?price=" + price;

          HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findUnitInStockLessThan(Integer stock) {
        String url = this.url + "/stockLess?stock=" + stock;

          HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findUnitInStockGreaterThan(Integer stock) {

        String url = this.url + "/stockGreater?stock=" + stock;

          HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
    }

    public List<ProductDTO> findUnitInStockBetween(Integer minStock, Integer maxStock) {

        String url = this.url + "/stockBetween?minStock=" + minStock + "&" + "maxStock=" + maxStock;

          HttpEntity<List<ProductDTO>> httpEntity = new HttpEntity<List<ProductDTO>>( HeaderSetter.setHeader());
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {
                });
        return response.getBody();
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
