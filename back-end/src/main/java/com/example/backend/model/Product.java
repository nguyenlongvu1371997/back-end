package com.example.backend.model;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateInput;
    private int amount;
    @ManyToOne
    @JoinColumn(name = "typeProduct_id", referencedColumnName = "id")
    private TypeProduct typeProduct;

    public Product(){
    };

    public Product(Integer id, String name, String dateInput, int amount, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.dateInput = dateInput;
        this.amount = amount;
        this.typeProduct = typeProduct;
    }

    public Product(String name, String dateInput, int amount, TypeProduct typeProduct) {
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
}
