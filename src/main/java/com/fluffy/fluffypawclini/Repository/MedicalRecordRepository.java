package com.fluffy.fluffypawclini.Repository;

import com.fluffy.fluffypawclini.Domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

    
    List<MedicalRecord> findByPet_PetId(Integer petId);

    List<MedicalRecord> findByTreatmentType(String treatmentType);

    default MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return save(medicalRecord); 
    }

    default List<MedicalRecord> getAllMedicalRecords() {
        return findAll(); 
    }

    default void deleteMedicalRecord(Integer recordId) {
        deleteById(recordId); 
    }
}
