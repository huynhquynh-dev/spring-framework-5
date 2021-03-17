package com.lionhuynh.springframework5.service.impl;

import com.lionhuynh.springframework5.model.Category;
import com.lionhuynh.springframework5.repositories.CategoryRepository;
import com.lionhuynh.springframework5.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByDescription(String description) {
        return categoryRepository.findByDescription(description);
    }
}
