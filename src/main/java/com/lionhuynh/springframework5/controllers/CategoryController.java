package com.lionhuynh.springframework5.controllers;

import com.lionhuynh.springframework5.model.Category;
import com.lionhuynh.springframework5.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<Category> getCategoryByDescription(@RequestParam("description") String description){
        Category category = categoryService.findByDescription(description);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
