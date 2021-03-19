package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
