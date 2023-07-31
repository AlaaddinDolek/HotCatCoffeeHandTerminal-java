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

import com.HandTerminal.HotCatCafe.DTOs.CategoryDTO;
import com.HandTerminal.HotCatCafe.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDTO categoryDTO, @RequestParam Long id) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, id));

    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteCategoryById(@RequestParam Long id) {
        return ResponseEntity.ok(categoryService.deleteCategoryById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("getById")
    public ResponseEntity<CategoryDTO> getCategoryById(@RequestParam Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/getByCategoryName")
    public ResponseEntity<CategoryDTO> getCategoryByCategoryName(@RequestParam String categoryName) {
        return ResponseEntity.ok(categoryService.getCategoryByCategoryName(categoryName));
    }
}