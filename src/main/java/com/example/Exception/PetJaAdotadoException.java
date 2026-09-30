package com.example.Exception;

public class PetJaAdotadoException extends RuntimeException {
    public PetJaAdotadoException(Long id){
        super("Pet adotado" + id);
    }
}
