package com.example.Springparking.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.time.Duration;
import java.util.Date;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    @NotBlank
    private String nombrePropietario;

    @Column
    @NotBlank
    private String apellidoPropietario;

    @Column
    @NotBlank
    private String modeloAuto;

    @Column
    @NotBlank
    @Temporal(TemporalType.TIME)
    private Time horaLlegada;

    @ManyToOne
    private Garage garage;

    public Client() {
    }


    public Client(Long id, String nombrePropietario, String apellidoPropietario, String modeloAuto,
                  Time horaLlegada, Garage garage) {
        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.modeloAuto = modeloAuto;
        this.horaLlegada = horaLlegada;
        this.garage = garage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nombrePropietario='" + nombrePropietario + '\'' +
                ", apellidoPropietario='" + apellidoPropietario + '\'' +
                ", modeloAuto='" + modeloAuto + '\'' +
                ", horaLlegada=" + horaLlegada +
                ", garage=" + garage +
                '}';
    }
}
