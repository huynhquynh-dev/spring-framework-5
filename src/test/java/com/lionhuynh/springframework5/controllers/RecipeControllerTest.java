package com.lionhuynh.springframework5.controllers;

import com.lionhuynh.springframework5.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    RecipeController recipeController;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        recipeController = new RecipeController(recipeService);
    }

    @Test
    void getAll() {

        String viewName = recipeController.getAll(model);

        assertEquals("recipe/index", viewName);

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}