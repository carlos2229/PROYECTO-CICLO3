package com.hibernate.softgeb.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estatus")
public class Estatus {

    // ATRIBUTOS

    @Id
    private int id_estatus;
    private String estatus;

    // CONSTRUCTORES
    public Estatus() {}

    public Estatus(int id_estatus, String estatus) {
        this.id_estatus = id_estatus;
        this.estatus = estatus;
    }

    // GETTERS
    // CONSULTORES

    public int getId_estatus() {
        return id_estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    // SETTERS
    // MODIFICADORES

    public void setId_estatus(int id_estatus) {
        this.id_estatus = id_estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

}