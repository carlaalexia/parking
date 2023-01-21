package com.example.Springparking.entity;


import jakarta.persistence.*;import java.sql.Time;

import java.util.Date;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String nombrePropietario;

    @Column
    private String apellidoPropietario;

    @Column
    private String modeloAuto;

    @Column
    private String horaLlegada;

    @Column
    private String horaSalida;

    @ManyToOne
    private Garage garage;

    public Client() {
    }


    public Client(Long id, String nombrePropietario, String apellidoPropietario, String modeloAuto,
                  String horaLlegada,String horaSalida, Garage garage) {
        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.modeloAuto = modeloAuto;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
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

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
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
