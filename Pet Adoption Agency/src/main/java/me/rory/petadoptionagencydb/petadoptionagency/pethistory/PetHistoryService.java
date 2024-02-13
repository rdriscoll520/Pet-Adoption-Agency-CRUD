package me.rory.petadoptionagencydb.petadoptionagency.pethistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetHistoryService {
    @Autowired private PetHistoryRepository repo;
    public List<PetHistory> listAll() {
        return (List<PetHistory>) repo.findAll();
    }

    public void save(PetHistory pethistory) {
        repo.save(pethistory);
    }
    public PetHistory get(Integer id) throws PetHistoryNotFoundException{
        Optional<PetHistory> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new PetHistoryNotFoundException("Could not find Pet History with id: " + id);
    }
    public void delete(Integer id) throws PetHistoryNotFoundException {
        Long count = repo.countByHistoryID(id);
        if(count ==null || count == 0) {
            throw new PetHistoryNotFoundException("Could not find history id: " + id);
        }
        repo.deleteById(id);
    }

    public class PetHistoryNotFoundException extends Throwable {
        public PetHistoryNotFoundException(String message) {
            super(message);
        }
    }
}
