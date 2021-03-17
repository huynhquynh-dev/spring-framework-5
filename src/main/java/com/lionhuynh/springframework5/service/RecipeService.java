package com.lionhuynh.springframework5.service;

import com.lionhuynh.springframework5.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
