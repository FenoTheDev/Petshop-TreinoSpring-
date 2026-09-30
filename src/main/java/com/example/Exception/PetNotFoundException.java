package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "n encontrou pet")
public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id){
        super("Pet n encontrado");
    }
    
}
