package me.rory.petadoptionagencydb.petadoptionagency.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class StaffService {
    @Autowired private StaffRepository repo;
    public List<Staff> listAll() {
        return (List<Staff>) repo.findAll();
    }

    public void save(Staff staff) {
        repo.save(staff);
    }
    public Staff get(Integer id) throws StaffNotFoundException{
        Optional<Staff> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new StaffNotFoundException("Could not find staff with id: " + id);
    }
    public void delete(Integer id) throws StaffNotFoundException {
        Long count = repo.countByStaffID(id);
        if(count ==null || count == 0) {
            throw new StaffNotFoundException("Could not find staff with id: " + id);
        }
        repo.deleteById(id);
    }

    public class StaffNotFoundException extends Throwable {
        public StaffNotFoundException(String message) {
            super(message);
        }
    }
}
