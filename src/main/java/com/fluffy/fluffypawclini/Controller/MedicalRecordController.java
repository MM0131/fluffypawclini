package com.fluffy.fluffypawclini.Controller;

import com.fluffy.fluffypawclini.Domain.MedicalRecord;
import com.fluffy.fluffypawclini.Repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    
    @PostMapping
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        MedicalRecord createdRecord = medicalRecordRepository.saveMedicalRecord(medicalRecord);
        return ResponseEntity.ok(createdRecord);
    }

    
    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        return ResponseEntity.ok(medicalRecordRepository.getAllMedicalRecords());
    }

    
    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByPetId(@PathVariable Integer petId) {
        return ResponseEntity.ok(medicalRecordRepository.findByPet_PetId(petId));
    }

    
    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Integer recordId) {
        medicalRecordRepository.deleteMedicalRecord(recordId);
        return ResponseEntity.noContent().build();
    }
}

