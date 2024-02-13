package me.rory.petadoptionagencydb.petadoptionagency.pets;

import me.rory.petadoptionagencydb.petadoptionagency.adopters.Adopter;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Integer> {
    public Long countByPetID(Integer id);
}
