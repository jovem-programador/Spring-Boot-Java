package com.anderson.crudspring.enums;

public enum Category {
    BACK_END("Back-End"), FRONT_END("ront-End");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // toString
    @Override
    public String toString() {
        return value;
    }

}
