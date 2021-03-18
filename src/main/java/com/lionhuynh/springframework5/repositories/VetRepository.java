package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
