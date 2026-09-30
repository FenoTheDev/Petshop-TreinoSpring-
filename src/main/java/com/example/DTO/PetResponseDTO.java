package com.example.DTO;

import com.example.Model.Pet.PetStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class PetResponseDTO {
     public String raca;
    public int idade;
    public String animalTipo; //Cachorro, papagaio e essas coisas
    public Long idAnimal;
    public PetStatus status_atual;
}
