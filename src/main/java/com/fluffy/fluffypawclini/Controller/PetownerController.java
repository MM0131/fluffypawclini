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

    
    @GetMapping
    public List<Petowner> getAllPetowners() {
        return petownerRepository.findAll();
    }

    
    @GetMapping("/phone/{phoneNumber}")
    public List<Petowner> getPetownersByPhoneNumber(@PathVariable String phoneNumber) {
        return petownerRepository.findByPhoneNumber(phoneNumber);
    }

    
    @GetMapping("/search")
    public List<Petowner> searchPetownersByFullName(@RequestParam String fullName) {
        return petownerRepository.findByFullNameContaining(fullName);
    }

    
    @PostMapping
    public Petowner createPetowner(@RequestBody Petowner petowner) {
        return petownerRepository.save(petowner);
    }

    
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

    
    @DeleteMapping("/{id}")
    public void deletePetowner(@PathVariable Integer id) {
        petownerRepository.deleteById(id);
    }
}
