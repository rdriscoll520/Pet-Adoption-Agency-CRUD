package me.rory.petadoptionagencydb.petadoptionagency.staff;

import me.rory.petadoptionagencydb.petadoptionagency.adopters.Adopter;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff,Integer> {
    public Long countByStaffID(Integer id);
}
