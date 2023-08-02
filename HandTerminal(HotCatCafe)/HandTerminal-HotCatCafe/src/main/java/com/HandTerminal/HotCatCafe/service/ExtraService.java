package com.HandTerminal.HotCatCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.DTOs.ExtraDTO;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class ExtraService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/extra";

    public ExtraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ExtraDTO> getAllExtras() {

        String url = this.url + "/getAll";

        HttpEntity<List<ExtraDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<ExtraDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ExtraDTO>>() {
                });

        return response.getBody();
    }

    public List<ExtraDTO> getExtrasByCategory(String categoryName) {

        String url = this.url + "/byCategoryName?categoryName=" + categoryName;

        HttpEntity<List<ExtraDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<ExtraDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<ExtraDTO>>() {
                });

        return response.getBody();
    }

    public ExtraDTO getExtraById(Long id) {

        String url = this.url + "/byId?id=" + id;

        ExtraDTO response = restTemplate.getForObject(url,
                ExtraDTO.class);

        return response;
    }

    public Long addExtra(ExtraDTO extraDTO) {

        String url = this.url + "/add";

        HttpEntity<ExtraDTO> httpEntity = new HttpEntity<>(extraDTO, HeaderSetter.setHeader());

        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                Long.class);

        return response.getBody();
    }

    public String deleteById(Long id) {

        String url = this.url + "/deleteById?id=" + id;

        HttpEntity<ExtraDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity,
                String.class);

        return response.getBody();
    }
}
