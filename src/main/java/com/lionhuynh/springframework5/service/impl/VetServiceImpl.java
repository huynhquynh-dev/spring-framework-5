package com.lionhuynh.springframework5.service.impl;

import com.lionhuynh.springframework5.model.Vet;
import com.lionhuynh.springframework5.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
