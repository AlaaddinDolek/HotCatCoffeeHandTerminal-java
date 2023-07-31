package com.HandTerminal.HotCatCafe.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<ExtraDTO>> getAllExtras() {
        return ResponseEntity.ok(extraService.getAllExtras());
    }

    @GetMapping("/byCategoryName")
    public ResponseEntity<List<ExtraDTO>> getExtrasByCategory(@RequestParam String categoryName) {
        return ResponseEntity.ok(extraService.getExtrasByCategory(categoryName));
    }

    @GetMapping("/byId")
    public ResponseEntity<ExtraDTO> getExtraById(@RequestParam Long id) {
        return ResponseEntity.ok(extraService.getExtraById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addExtra(@RequestBody ExtraDTO extraDTO) {
        return ResponseEntity.ok(extraService.addExtra(extraDTO));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        return ResponseEntity.ok(extraService.deleteById(id));
    }

}
