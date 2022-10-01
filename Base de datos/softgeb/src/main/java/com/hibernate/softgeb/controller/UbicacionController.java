package com.hibernate.softgeb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.softgeb.modelo.UbicacionModel;
import com.hibernate.softgeb.services.UbicacionService;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {

    private UbicacionService service;

    public UbicacionController() {
        this.service = new UbicacionService();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<UbicacionModel> listarEquipos() {
        List<UbicacionModel> ubicacion = new ArrayList<>();
        try {
            ubicacion = service.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ubicacion;
    }

    @PostMapping
    @CrossOrigin("*")
    public String crearEquipo(@RequestBody UbicacionModel ubicacion) {
        return service.create(ubicacion);
    }

    @PutMapping
    @CrossOrigin("*")
    public String actualizarEquipo(@RequestBody UbicacionModel ubicacion) {
        String message = "";
        try {
            service.update(ubicacion);
            message = "Los datos del equipo han sido actualizados con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "id") int id) {
        return service.delete(id);
    }
}
