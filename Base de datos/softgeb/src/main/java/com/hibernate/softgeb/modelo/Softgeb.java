package com.hibernate.softgeb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="softgeb")
public class Softgeb {
    
    // ATRIBUTOS
    @Id
    private  int id;
    private String nombre_equipo;
    private String marca;
    //@Column(name="tipo_mascota")
    private String modelo;
    private String ubicacion;
    private String estatus;
    private String observacion;
    
    // CONSTRUCTORES
    public Softgeb(){}

    public Softgeb(String nombre_equipo, String marca, String modelo, String ubicacion, String estatus, String observacion) {
        this.nombre_equipo = nombre_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.estatus = estatus;
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        String info = "------------------------------\n";
        info += "Id: "+id;
        info += "\nNombre del equipo: "+nombre_equipo;
        info += "\nMarca del equipo: "+marca;
        info += "\nModelo del equipo: "+modelo;
        info += "\nUbicacion: "+ubicacion;
        info += "\nEstatus del equipo: "+estatus;
        info += "\nObservaciones: "+observacion;
        info += "\n------------------------------\n";

        return info;
    }

    // CONSULTORES // GETTERS

    public int getId() {
        return id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getObservacion() {
        return observacion;
    }

    // MODIFICADORES // SETTERS

    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
        
}
