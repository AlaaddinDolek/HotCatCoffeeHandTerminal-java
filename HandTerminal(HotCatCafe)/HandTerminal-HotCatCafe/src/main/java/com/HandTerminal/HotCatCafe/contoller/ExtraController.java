package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HandTerminal.HotCatCafe.DTOs.ExtraDTO;
import com.HandTerminal.HotCatCafe.service.ExtraService;

@RestController
@RequestMapping("/extra")
public class ExtraController {

    @Autowired
    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping
    public ResponseEntity<List<ExtraDTO>> getAllExtras() {
        return ResponseEntity.ok(extraService.getAllExtras());
    }

    @GetMapping("/name/{categoryName}")
    public ResponseEntity<List<ExtraDTO>> getExtrasByCategory(@PathVariable String categoryName) {
        return ResponseEntity.ok(extraService.getExtrasByCategory(categoryName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ExtraDTO> getExtraById(@PathVariable Long id) {
        return ResponseEntity.ok(extraService.getExtraById(id));
    }

    @PostMapping
    public ResponseEntity<Long> addExtra(@RequestBody ExtraDTO extraDTO) {
        return ResponseEntity.ok(extraService.addExtra(extraDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(extraService.deleteById(id));
    }

}
