package com.example.Service;

import com.example.Controller.PetController;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DTO.PetRequestDTO;
import com.example.Exception.PetJaAdotadoException;
import com.example.Exception.PetNotFoundException;
import com.example.Model.Pet;
import com.example.Model.Pet.PetStatus;
import com.example.Repository.PetRepository;

@Service 
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository){
        this.repository = repository;
    }

    public List<Pet> ListarPet(){
        return repository.findAll();
    }

    public Pet cadastrarPet(PetRequestDTO pet){
        Pet petNovo = new Pet();

        petNovo.setAnimalTipo(pet.getAnimalTipo());
        petNovo.setIdade(pet.getIdade());
        petNovo.setRaca(pet.getRaca());
        petNovo.setStatus_atual(PetStatus.DISPONIVEL);
        return repository.save(petNovo);
    }

    
    public Pet adotarPet(Long id){
        Pet petExistente = repository.findById(id)
        .orElseThrow(() -> new PetNotFoundException(id));

       if(petExistente.status_atual != petExistente.status_atual.ADOTADO){
             petExistente.setStatus_atual(PetStatus.ADOTADO);
             return repository.save(petExistente);
       }
       else{
        throw new PetJaAdotadoException(id);
       }
       
    }

    public void deletarRegistro(Long id){
        repository.deleteById(id);
    }
}
