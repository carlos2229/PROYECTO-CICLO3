package com.hibernate.softgeb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Softgeb")
public class Softgeb {

    // ATRIBUTOS
    @Id
    private int id;
    private String nombre_equipo;
    private String marca;
    // @Column(name="tipo_mascota")
    private String modelo;

    @JoinColumn(name = "id_ubicacion")
    @ManyToOne
    private Ubicacion ubicacion;

    @JoinColumn(name = "id_estatus")
    @OneToOne
    private Estatus estatus;

    // CONSTRUCTORES

    @Override
    public String toString() {
        String info = "------------------------------\n";
        info += "Id: " + id;
        info += "\nNombre del equipo: " + nombre_equipo;
        info += "\nMarca del equipo: " + marca;
        info += "\nModelo del equipo: " + modelo;
        info += "\nUbicacion: " + ubicacion;
        info += "\nEstatus del equipo: " + estatus;
        info += "\n------------------------------\n";

        return info;
    }

    // CONSULTORES

    public Softgeb() {
    }

    public Softgeb(int id, String nombre_equipo, String marca, String modelo,
            Ubicacion ubicacion, Estatus estatus) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.estatus = estatus;
    }

    // GETTERS
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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    // MODIFICADORES // SETTERS

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

}
