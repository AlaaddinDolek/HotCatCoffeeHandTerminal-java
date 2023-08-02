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

    @PostMapping
    public ResponseEntity<Long> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/name/{categoryName}")
    public ResponseEntity<CategoryDTO> getCategoryByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity.ok(categoryService.getCategoryByCategoryName(categoryName));
    }
}