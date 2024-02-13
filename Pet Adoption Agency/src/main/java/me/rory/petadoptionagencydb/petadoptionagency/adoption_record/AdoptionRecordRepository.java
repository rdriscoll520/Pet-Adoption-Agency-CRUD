package me.rory.petadoptionagencydb.petadoptionagency.adoption_record;

import org.springframework.data.repository.CrudRepository;

public interface AdoptionRecordRepository extends CrudRepository<AdoptionRecord,Integer> {
    public Long countByRecordID(Integer id);
}
