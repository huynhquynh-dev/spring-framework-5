package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
