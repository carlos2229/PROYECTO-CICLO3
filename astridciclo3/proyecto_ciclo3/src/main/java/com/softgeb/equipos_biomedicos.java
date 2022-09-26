package com.softgeb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "equipos_biomedicos")

public class equipos_biomedicos{

    //ATRIBUTOS
    @Id
    private int id;
    private String nombre_equipo;
    private String marca;
    private String modelo;
    private String ubicacion;
    private String estatus; 

    //CONTRUCTORES
    public equipos_biomedicos() {}

    public equipos_biomedicos(String nombre_equipo, String marca, String modelo, String ubicacion, String estatus) {
     this.nombre_equipo = nombre_equipo;
     this.marca = marca; 
     this.modelo = modelo;
     this.ubicacion = ubicacion;
     this.estatus = estatus;
     
    }

    //CONSULTORES //GETTERS

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


    //MODIFICADORES // SETTERS

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    } 