package com.example.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(PetNotFoundException.class)
    public ProblemDetail handlePetNaoEncontrado(PetNotFoundException pd){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, pd.getMessage());
    }

    @ExceptionHandler(PetJaAdotadoException.class)
    public ProblemDetail handlePetJaAdotado(PetJaAdotadoException pd){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, pd.getMessage());
    }
}
