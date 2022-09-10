package com.proyectoColegio.colegio.modelos;

import javax.persistence.*;


enum Roles {
    ADMINISTRATIVO,OPERATIVO;
}


@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nombre;
    private String correo;
    @ManyToOne
    @JoinColumn(name = "colegio_id")
    private Colegios colegios;
    public Roles rol;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, Colegios colegios, Roles rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.colegios = colegios;
        this.rol = Roles.OPERATIVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Colegios getColegios() {
        return colegios;
    }

    public void setColegios(Colegios colegios) {
        this.colegios = colegios;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
