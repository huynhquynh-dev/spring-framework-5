package com.lionhuynh.springframework5.service;

import com.lionhuynh.springframework5.model.Category;

public interface CategoryService {
    Category findByDescription(String description);
}
