package com.fluffy.fluffypawclini.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.fluffy.fluffypawclini.Domain.Pet;
import com.fluffy.fluffypawclini.Repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    
    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public Optional<Pet> getPetById(@PathVariable Long id) {
        return petRepository.findById(id);
    }

    
    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    
    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(updatedPet.getName());
            pet.setAge(updatedPet.getAge());
            pet.setType(updatedPet.getType());
            return petRepository.save(pet);
        }).orElseGet(() -> {
            updatedPet.setId(id);
            return petRepository.save(updatedPet);
        });
    }

    
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
    }
}
