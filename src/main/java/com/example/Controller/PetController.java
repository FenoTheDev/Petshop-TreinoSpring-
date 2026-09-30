package com.example.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.PetRequestDTO;
import com.example.DTO.PetResponseDTO;
import com.example.Model.Pet;
import com.example.Service.PetService;

import lombok.experimental.var;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/Petshop")
public class PetController {
    private final PetService service;

    public PetController(PetService service){
        this.service = service;
    }


    @GetMapping
    public List<Pet> listar(){
        return service.ListarPet();
    }

    @PostMapping
    public ResponseEntity<PetResponseDTO> cadastrarPet( @RequestBody PetRequestDTO dto){
        Pet salvo = service.cadastrarPet(dto);
        PetResponseDTO responseDTO = new PetResponseDTO();

        responseDTO.setAnimalTipo(salvo.getAnimalTipo());
        responseDTO.setIdAnimal(salvo.getIdAnimal());
        responseDTO.setIdade(salvo.getIdade());
        responseDTO.setRaca(salvo.getRaca());
        responseDTO.setStatus_atual(salvo.getStatus_atual());

        lombok.experimental.var uri = URI.create("/Petshop/" + salvo.getIdAnimal());
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping("/{id}/adotar")
    public Pet adotarPet(@PathVariable Long id){
        return service.adotarPet(id);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable Long id){
        service.deletarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}
