package com.HandTerminal.HotCatCafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HandTerminal.HotCatCafe.DTOs.EmployeeDTO;
import com.HandTerminal.HotCatCafe.common.HeaderSetter;

@Service
public class EmployeeService {
    @Autowired
    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/employee";

    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EmployeeDTO> getAllEmployees() {

        String url = this.url + "/getAll";

        HttpEntity<List<EmployeeDTO>> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<List<EmployeeDTO>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {
                });

        return response.getBody();
    }

    public EmployeeDTO findEmployeeById(Long id) {

        String url = this.url + "/byId?id=" + id;

        EmployeeDTO response = restTemplate.getForObject(url,
                EmployeeDTO.class);

        return response;
    }

    public Long addEmployee(EmployeeDTO employeeDTO) {
        String url = this.url + "/add";

        HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(employeeDTO, HeaderSetter.setHeader());

        HttpEntity<Long> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Long.class);

        return response.getBody();
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id) {

        String url = this.url + "/update?id=" + id;

        HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(employeeDTO, HeaderSetter.setHeader());

        ResponseEntity<EmployeeDTO> response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity,
                EmployeeDTO.class);

        return response.getBody();
    }

    public String deleteById(Long id) {

        String url = this.url + "/deleteById?id=" + id;

        HttpEntity<EmployeeDTO> httpEntity = new HttpEntity<>(HeaderSetter.setHeader());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);

        return response.getBody();

    }
}
