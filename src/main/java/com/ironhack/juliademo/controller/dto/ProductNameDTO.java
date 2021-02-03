package com.ironhack.juliademo.controller.dto;

import javax.validation.constraints.NotEmpty;

public class ProductNameDTO {
    @NotEmpty(message = "El nombre no puede ser vacío >:C")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
