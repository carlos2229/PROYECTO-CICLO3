package com.hibernate.softgeb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Softgeb {

    // ATRIBUTOS
    @Id
    private int idequipos;
    private String nombre_equipo;
    private String marca;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion")
   
    private Ubicacion ubicacion_id_ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_estatus")
    
    private Estatus estatus_id_estatus;

    // CONSTRUCTORES

    @Override
    public String toString() {
        String info = "------------------------------\n";
        info += "Id: " + idequipos;
        info += "\nNombre del equipo: " + nombre_equipo;
        info += "\nMarca del equipo: " + marca;
        info += "\nModelo del equipo: " + modelo;
        info += "\nUbicacion: " + ubicacion_id_ubicacion;
        info += "\nEstatus del equipo: " + estatus_id_estatus;
        info += "\n------------------------------\n";

        return info;
    }

    // CONSULTORES

    public Softgeb() {
    }

    public Softgeb(int idequipos, String nombre_equipo, String marca, String modelo, Ubicacion ubicacion_id_ubicacion,
            Estatus estatus_id_estatus) {
        this.idequipos = idequipos;
        this.nombre_equipo = nombre_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion_id_ubicacion = ubicacion_id_ubicacion;
        this.estatus_id_estatus = estatus_id_estatus;
    }

    public int getId() {
        return idequipos;
    }

    public void setId(int idequipos) {
        this.idequipos = idequipos;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Ubicacion getUbicacion_id_ubicacion() {
        return ubicacion_id_ubicacion;
    }

    public void setUbicacion_id_ubicacion(Ubicacion ubicacion_id_ubicacion) {
        this.ubicacion_id_ubicacion = ubicacion_id_ubicacion;
    }

    public Estatus getEstatus_id_estatus() {
        return estatus_id_estatus;
    }

    public void setEstatus_id_estatus(Estatus estatus_id_estatus) {
        this.estatus_id_estatus = estatus_id_estatus;
    }

   }
