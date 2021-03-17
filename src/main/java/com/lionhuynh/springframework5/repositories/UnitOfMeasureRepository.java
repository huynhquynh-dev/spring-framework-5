package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
}
