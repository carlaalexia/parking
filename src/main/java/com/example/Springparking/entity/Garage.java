package com.example.Springparking.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer capacidad;

    public Garage() {
    }

    public Garage(Long id, Integer capacidad) {
        this.id = id;
        this.capacidad = 10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
