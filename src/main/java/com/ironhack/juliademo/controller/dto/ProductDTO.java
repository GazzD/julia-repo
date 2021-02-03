package com.ironhack.juliademo.controller.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class ProductDTO {
    @NotEmpty(message = "El nombre no puede ser vacío >:C")
    private String name;
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    @NotEmpty(message = "La categoría no puede ser vacía :D")
    private String category;
    @NotEmpty(message = "El departamento no puede ser vacío :O")
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
