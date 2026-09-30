package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Pet;

@Repository 
public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
