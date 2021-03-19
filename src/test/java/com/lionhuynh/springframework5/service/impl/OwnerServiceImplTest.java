package com.lionhuynh.springframework5.service.impl;

import com.lionhuynh.springframework5.model.Owner;
import com.lionhuynh.springframework5.repositories.OwnerRepository;
import com.lionhuynh.springframework5.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.SecondaryTable;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceImplTest {

    private final Long ownerId = 1L;
    private final String lastname = "Smith";

    @Autowired
    OwnerRepository ownerRepository;

    OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceImpl(ownerRepository, new PetTypeServiceImpl(), new PetServiceImpl());
        ownerService.save(Owner.builder().id(ownerId).lastName(lastname).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();

        Owner saveOwner = ownerService.save(owner);

        assertEquals(id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();

        Owner saveOwner = ownerService.save(owner);

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void delete() {
        ownerService.deleteById(ownerService.findById(ownerId).getId());

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(lastname);

        assertNotNull(owner);
        assertNotNull(owner.getId());
        assertEquals(lastname, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerService.findByLastName("foo");

        assertNull(owner);
    }

    @Test
    void findAllByLastNameLike() {
    }
}