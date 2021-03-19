package com.lionhuynh.springframework5.controllers;

import com.lionhuynh.springframework5.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/all")
    public String getAll(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipe/index";
    }
}
