package com.fluffy.fluffypawclini.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fluffy.fluffypawclini.Domain.Pet;

// Interface for Pet Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // Custom query methods (if needed) can be added here, for example:
    List<Pet> findByName(String name);
}
