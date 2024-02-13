package me.rory.petadoptionagencydb.petadoptionagency.adoption_record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class AdoptionRecordService {
    @Autowired private AdoptionRecordRepository repo;
    public List<AdoptionRecord> listAll() {
        return (List<AdoptionRecord>) repo.findAll();
    }

    public void save(AdoptionRecord adoptionRecord) {
        repo.save(adoptionRecord);
    }
    public AdoptionRecord get(Integer id) throws AdoptionRecordNotFoundException{
        Optional<AdoptionRecord> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new AdoptionRecordNotFoundException("Could not find record with id: " + id);
    }
    public void delete(Integer id) throws AdoptionRecordNotFoundException {
        Long count = repo.countByRecordID(id);
        if(count ==null || count == 0) {
            throw new AdoptionRecordNotFoundException("Could not find record with id: " + id);
        }
        repo.deleteById(id);
    }

    public class AdoptionRecordNotFoundException extends Throwable {
        public AdoptionRecordNotFoundException(String message) {
            super(message);
        }
    }
}
