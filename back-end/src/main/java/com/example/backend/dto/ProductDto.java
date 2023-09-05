package com.example.backend.dto;

import com.example.backend.model.TypeProduct;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class ProductDto implements Validator {
    private Integer id;

    @NotBlank(message = "can't be empty")
    @Size(max = 100, message = "too long")
    private String name;
    private String dateInput;
    @Size(min = 0, message = "too short")
    private int amount;
    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public ProductDto(String name, String dateInput, int amount, TypeProduct typeProduct) {

        this.name = name;
        this.dateInput = dateInput;
        this.amount = amount;
        this.typeProduct = typeProduct;
    }

    public ProductDto(Integer id, String name, String dateInput, int amount, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.dateInput = dateInput;
        this.amount = amount;
        this.typeProduct = typeProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateInput() {
        return dateInput;
    }

    public void setDateInput(String dateInput) {
        this.dateInput = dateInput;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
