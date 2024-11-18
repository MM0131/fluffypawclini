package com.fluffy.fluffypawclini.Repository;

import com.fluffy.fluffypawclini.Domain.Petowner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetownerRepository extends JpaRepository<Petowner, Integer> {

    // ค้นหาจากหมายเลขโทรศัพท์
    List<Petowner> findByPhoneNumber(String phoneNumber);

    // ค้นหาจากชื่อ
    List<Petowner> findByFullNameContaining(String fullName);

}
