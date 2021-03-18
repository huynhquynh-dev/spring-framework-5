package com.lionhuynh.springframework5.service.impl;

import com.lionhuynh.springframework5.model.Owner;
import com.lionhuynh.springframework5.model.Pet;
import com.lionhuynh.springframework5.repositories.OwnerRepository;
import com.lionhuynh.springframework5.service.OwnerService;
import com.lionhuynh.springframework5.service.PetService;
import com.lionhuynh.springframework5.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PetTypeService petTypeService, PetService petService) {
        this.ownerRepository = ownerRepository;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
