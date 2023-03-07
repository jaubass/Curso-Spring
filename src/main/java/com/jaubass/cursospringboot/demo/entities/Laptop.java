package com.jaubass.cursospringboot.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

@Entity
@Table(name = "laptops")
public class Laptop {

    // Atributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Model;
    private Double price;
    private LocalDate release;
    private Boolean available;

    // Constructors


    public Laptop() {}

    public Laptop(Long id, String model, Double price, LocalDate release, Boolean available) {
        this.id = id;
        Model = model;
        this.price = price;
        this.release = release;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
