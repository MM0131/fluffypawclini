package com.fluffy.fluffypawclini.Domain;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@Entity 
@Table(name = "MedicalRecord")
public class MedicalRecord {

    @Id // กำหนด Primary Key
    @Column(name = "PetID", nullable = false) 
    private Integer petId;

    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "RecordID") // ชื่อคอลัมน์ในฐานข้อมูล
    private Integer recordId;

    @Column(name = "TreatmentType", length = 50) 
    private String treatmentType;

    @Column(name = "MedicalName", columnDefinition = "TEXT") 
    private String medicalName;

    @Column(name = "DateOfRecord") 
    @JsonFormat(pattern = "yyyy-MM-dd") // กำหนดรูปแบบวันที่
    private LocalDate dateOfRecord;

    @Column(name = "Price") // ราคา
    private Integer price;

    @Column(name = "Appointment", length = 50) // รายละเอียดการนัดหมาย
    private String appointment;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAppointment() {
        return appointment;
    }
package com.fluffy.fluffypawclini.Controller;

import com.fluffy.fluffypawclini.Domain.Petowner;
import com.fluffy.fluffypawclini.Repository.PetownerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petowners")
public class PetownerController {

    @Autowired
    private PetownerRepository petownerRepository;

    // Get all pet owners
    @GetMapping
    public List<Petowner> getAllPetowners() {
        return petownerRepository.findAll();
    }

    // Get pet owner by phone number
    @GetMapping("/phone/{phoneNumber}")
    public List<Petowner> getPetownersByPhoneNumber(@PathVariable String phoneNumber) {
        return petownerRepository.findByPhoneNumber(phoneNumber);
    }

    // Get pet owners by full name containing a keyword
    @GetMapping("/search")
    public List<Petowner> searchPetownersByFullName(@RequestParam String fullName) {
        return petownerRepository.findByFullNameContaining(fullName);
    }

    // Create a new pet owner
    @PostMapping
    public Petowner createPetowner(@RequestBody Petowner petowner) {
        return petownerRepository.save(petowner);
    }

    // Update an existing pet owner
    @PutMapping("/{id}")
    public Petowner updatePetowner(@PathVariable Integer id, @RequestBody Petowner updatedPetowner) {
        return petownerRepository.findById(id).map(petowner -> {
            petowner.setFullName(updatedPetowner.getFullName());
            petowner.setPhoneNumber(updatedPetowner.getPhoneNumber());
            petowner.setAddress(updatedPetowner.getAddress());
            return petownerRepository.save(petowner);
        }).orElseGet(() -> {
            updatedPetowner.setId(id);
            return petownerRepository.save(updatedPetowner);
        });
    }

    // Delete a pet owner by ID
    @DeleteMapping("/{id}")
    public void deletePetowner(@PathVariable Integer id) {
        petownerRepository.deleteById(id);
    }
}

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
    @ManyToOne
    @JoinColumn(name = "PetID", nullable = false) 
    private Pet pet;

}

