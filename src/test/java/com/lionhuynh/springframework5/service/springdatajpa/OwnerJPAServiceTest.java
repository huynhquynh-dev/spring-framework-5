package com.lionhuynh.springframework5.service.springdatajpa;

import com.lionhuynh.springframework5.model.Owner;
import com.lionhuynh.springframework5.repositories.OwnerRepository;
import com.lionhuynh.springframework5.service.PetService;
import com.lionhuynh.springframework5.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    final Long ownerId = 1L;
    final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    @InjectMocks
    OwnerJPAService ownerJPAService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(new Owner());
        ownerSet.add(Owner.builder().id(ownerId).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> returnOwners = ownerJPAService.findAll();

        assertEquals(2, returnOwners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerJPAService.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerJPAService.findById(ownerId);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(ownerId).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = ownerJPAService.save(ownerToSave);

        assertNotNull(owner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerJPAService.delete(ownerJPAService.findById(ownerId));

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(ownerId);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);

        Owner owner = ownerRepository.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(LAST_NAME);
    }

    @Test
    void findAllByLastNameLike() {
    }
}