package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
