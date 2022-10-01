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

import com.hibernate.softgeb.modelo.EstatusModel;
import com.hibernate.softgeb.services.EstatusService;

@RestController
@RequestMapping("/estatus")
public class EstatusController {

    private EstatusService service;

    public EstatusController() {
        this.service = new EstatusService();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<EstatusModel> listarEquipos() {
        List<EstatusModel> equipos = new ArrayList<>();
        try {
            equipos = service.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }

    @PostMapping
    @CrossOrigin("*")
    public String crearEquipo(@RequestBody EstatusModel equipos) {
        return service.create(equipos);
    }

    @PutMapping
    @CrossOrigin("*")
    public String actualizarEquipo(@RequestBody EstatusModel equipos) {
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
