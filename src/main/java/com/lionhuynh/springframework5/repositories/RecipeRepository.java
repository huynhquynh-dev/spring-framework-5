package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
