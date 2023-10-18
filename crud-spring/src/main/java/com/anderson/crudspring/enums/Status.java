package com.anderson.crudspring.enums;

public enum Status {

    // Valores
    ACTIVE("Ativo"),INACTIVE("Inativo");

    // Var de dados
    private String value;

    // Construtor
    private Status(String value) {
        this.value = value;
    }

    // Metodo GET 
    public String getValue() {
        return value;
    }

    // Metodo toString
    @Override
    public String toString() {
        return value;
    }
}
