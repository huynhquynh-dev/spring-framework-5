package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
