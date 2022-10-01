package com.hibernate.softgeb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.softgeb.modelo.EquipoModel;
import com.hibernate.softgeb.services.EquipoService;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    
    private EquipoService service;

    public EquipoController() {
        this.service = new EquipoService();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<EquipoModel> listarEquipos() {
        List<EquipoModel> equipos = new ArrayList<>();
        try {
            equipos = service.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }
    @PostMapping
    @CrossOrigin("*")
    public String crearEquipo(@RequestBody EquipoModel equipos) {
        return service.create(equipos);
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public EquipoModel consultarEquipoXid(@PathVariable(name = "id") int id) {
        EquipoModel equipos = new EquipoModel();
        try {
            equipos = service.readById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }

    @GetMapping("/nombre")
    @CrossOrigin("*")
    public List<EquipoModel> consultarEquipoXnombre(@RequestParam String nombre_equipo) {
        List<EquipoModel> equipos = new ArrayList<>();
        try {
            equipos = service.getByName(nombre_equipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }

    @PutMapping
    @CrossOrigin("*")
    public String actualizarEquipo(@RequestBody EquipoModel equipos) {
        String message = "";
        try {
            service.update(equipos);
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
