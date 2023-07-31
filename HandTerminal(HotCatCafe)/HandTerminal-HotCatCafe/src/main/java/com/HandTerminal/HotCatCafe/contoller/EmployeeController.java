package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDTO>> getAllCategories() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/byId")
    public ResponseEntity<EmployeeDTO> findEmployeeById(@RequestParam Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));

    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @RequestParam Long id) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO, id));

    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        return ResponseEntity.ok(employeeService.deleteById(id));

    }

}
