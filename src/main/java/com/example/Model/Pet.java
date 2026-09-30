package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity 

public class Pet {
    public String raca;
    public int idade;
    public String animalTipo; //Cachorro, papagaio e essas coisas
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idAnimal;
    public enum PetStatus {
        ADOTADO,
        DISPONIVEL
    }
    public PetStatus status_atual;
}
