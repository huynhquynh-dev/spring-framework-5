package com.lionhuynh.springframework5.controllers;

import com.lionhuynh.springframework5.model.Recipe;
import com.lionhuynh.springframework5.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

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

//        Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(4L);

        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

//        when
        String viewName = recipeController.getAll(model);

//        when
        assertEquals("recipe/index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setRecipeController = argumentCaptor.getValue();
        assertEquals(2, setRecipeController.size());
    }
}