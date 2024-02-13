package me.rory.petadoptionagencydb.petadoptionagency.adopters;

import org.springframework.data.repository.CrudRepository;

public interface AdopterRepository extends CrudRepository<Adopter,Integer> {
    public Long countByAdopterID(Integer id);
}
