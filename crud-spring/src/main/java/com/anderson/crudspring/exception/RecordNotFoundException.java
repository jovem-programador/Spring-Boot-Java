package com.anderson.crudspring.exception;

public class RecordNotFoundException extends RuntimeException{
    
    /*
     * Representa as exeções
    */

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Registro não encontrado com o id: " + id);
    }
}
