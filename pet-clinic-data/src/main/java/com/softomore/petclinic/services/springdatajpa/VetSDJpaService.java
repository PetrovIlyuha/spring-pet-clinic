package com.softomore.petclinic.services.springdatajpa;

import com.softomore.petclinic.model.Vet;
import com.softomore.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {



    @Override
    public Set<Vet> findAll() {
        return null;
    }

    @Override
    public Vet findById(Long aLong) {
        return null;
    }

    @Override
    public Vet save(Vet object) {
        return null;
    }

    @Override
    public void delete(Vet object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
