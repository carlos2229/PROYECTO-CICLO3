package com.hibernate.softgeb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ubicacion")
public class UbicacionModel {
    
    // ATRIBUTOS

    @Id
    private int id_ubicacion;
    private String ubicacion;

    // CONSTRUCTORES
    
    public UbicacionModel(int id_ubicacion, String ubicacion){
        this.id_ubicacion = id_ubicacion;
        this.ubicacion = ubicacion;
    }
    
    public UbicacionModel(){}

    // GETTERS
    //CONSULTORES
    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // SETTERS
    //MODIFICADORES

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
