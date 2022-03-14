package services;

import java.util.Set;

public interface CrudService<Vet, ID> {
    Set<Vet> findAll();

    Vet findById(ID id);

    Vet save(Vet object);

    void delete(Vet object);

    void deleteById(ID id);
}
