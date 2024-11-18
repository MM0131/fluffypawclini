package com.fluffy.fluffypawclini.Domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PetID") // Primary Key
    private Integer petId;

    @Column(name = "DateOfVisit") // วันที่เข้ารับบริการ
    private String dateOfVisit;

    @Column(name = "Gender", length = 15) // เพศของสัตว์เลี้ยง
    private String gender;

    @Column(name = "Age", length = 10) // อายุ
    private String age;

    @Column(name = "Weight", length = 10) // น้ำหนัก
    private String weight;

    @Column(name = "CoatColor", length = 50) // สีของขน
    private String coatColor;

    @Column(name = "Breed", length = 50) // สายพันธุ์
    private String breed;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<MedicalRecord> medicalRecords;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
