package com.HandTerminal.HotCatCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.DTOs.CategoryDTO;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class CategoryService {

    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/category";

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {

        String url = this.url + "/add";

        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(categoryDTO, HeaderSetter.setHeader());

        ResponseEntity<CategoryDTO> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                CategoryDTO.class);

        return response.getBody();

    }

    public String updateCategory(@RequestBody CategoryDTO categoryDTO, @RequestParam Long id) {
        String url = this.url + "/update?id=" + id;

        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(categoryDTO, HeaderSetter.setHeader());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        return response.getBody();
    }

    public String deleteCategoryById(@RequestParam Long id) {
        String url = this.url + "/deleteById?id=" + id;

        HttpEntity<String> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
        return response.getBody();

    }

    public List<CategoryDTO> getAllCategories() {

        String url = this.url + "/getAll";

        HttpEntity<List<CategoryDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<CategoryDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<CategoryDTO>>() {
                });

        return response.getBody();
    }

    public CategoryDTO getCategoryById(@RequestParam Long id) {

        String url = this.url + "/getById?id=" + id;

        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<CategoryDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                CategoryDTO.class);

        return response.getBody();

    }

    public CategoryDTO getCategoryByCategoryName(@RequestParam String categoryName) {

        String url = this.url + "/getByCategoryName?categoryName=" + categoryName;

        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<CategoryDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                CategoryDTO.class);

        return response.getBody();

    }
}
