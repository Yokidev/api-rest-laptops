package com.example.Ejercicios456.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "laptops")
public class Laptop {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String model;
    private Double price;
    private LocalDate realeseDate;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String model, Double price, LocalDate realeseDate) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.price = price;
        this.realeseDate = realeseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(LocalDate realeseDate) {
        this.realeseDate = realeseDate;
    }
}
