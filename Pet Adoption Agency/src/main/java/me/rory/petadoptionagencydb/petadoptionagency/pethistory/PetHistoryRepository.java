package me.rory.petadoptionagencydb.petadoptionagency.pethistory;

import org.springframework.data.repository.CrudRepository;

public interface PetHistoryRepository extends CrudRepository<PetHistory,Integer> {
    public Long countByHistoryID(Integer id);
}
