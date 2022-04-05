package com.softomore.petclinic.services;

import java.util.Set;

public interface CrudService<Visit, ID> {
    Set<Visit> findAll();

    Visit findById(ID id);

    Visit save(Visit object);

    void delete(Visit object);

    void deleteById(ID id);
}
