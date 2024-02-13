package me.rory.petadoptionagencydb.petadoptionagency.adopters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class AdopterService {
    @Autowired private AdopterRepository repo;
    public List<Adopter> listAll() {
        return (List<Adopter>) repo.findAll();
    }

    public void save(Adopter adopter) {
        repo.save(adopter);
    }
    public Adopter get(Integer id) throws AdopterNotFoundException{
        Optional<Adopter> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new AdopterNotFoundException("Could not find adopter with id: " + id);
    }
    public void delete(Integer id) throws AdopterNotFoundException {
        Long count = repo.countByAdopterID(id);
        if(count ==null || count == 0) {
            throw new AdopterNotFoundException("Could not find adopter with id: " + id);
        }
        repo.deleteById(id);
    }

    public class AdopterNotFoundException extends Throwable {
        public AdopterNotFoundException(String message) {
            super(message);
        }
    }
}
