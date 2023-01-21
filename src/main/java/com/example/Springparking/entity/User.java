package com.example.Springparking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(unique = true)
    private String mail;
    @Column(unique = true)
    private String nombreUsuario;
    @Column
    private String contraseña;

    @Transient
    private String confirmarContraseña;

    public User() {
    }

    public User(Long id, String nombre, String apellido,
                String mail, String nombreUsuario, String contraseña, String confirmarContraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.confirmarContraseña = confirmarContraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }



}


