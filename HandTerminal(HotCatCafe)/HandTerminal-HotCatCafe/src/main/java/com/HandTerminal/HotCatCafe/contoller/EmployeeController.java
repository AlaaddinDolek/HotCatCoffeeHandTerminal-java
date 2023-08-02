package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.EmployeeDTO;
import com.HandTerminal.HotCatCafe.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllCategories() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Long> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteById(id));

    }

}
