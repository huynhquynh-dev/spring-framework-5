package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
