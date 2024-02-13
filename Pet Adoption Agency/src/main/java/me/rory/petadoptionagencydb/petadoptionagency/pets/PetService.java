package me.rory.petadoptionagencydb.petadoptionagency.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired private PetRepository repo;
    public List<Pet> listAll() {
        return (List<Pet>) repo.findAll();
    }

    public void save(Pet pet) {
        repo.save(pet);
    }
    public Pet get(Integer id) throws PetNotFoundException{
        Optional<Pet> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new PetNotFoundException("Could not find pet with id: " + id);
    }
    public void delete(Integer id) throws PetNotFoundException {
        Long count = repo.countByPetID(id);
        if(count ==null || count == 0) {
            throw new PetNotFoundException("Could not find pet with id: " + id);
        }
        repo.deleteById(id);
    }

    public class PetNotFoundException extends Throwable {
        public PetNotFoundException(String message) {
            super(message);
        }
    }
}
