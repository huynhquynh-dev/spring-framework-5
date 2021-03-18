package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
