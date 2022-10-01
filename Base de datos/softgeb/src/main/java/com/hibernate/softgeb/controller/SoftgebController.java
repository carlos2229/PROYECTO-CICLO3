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

import com.hibernate.softgeb.modelo.Softgeb;
import com.hibernate.softgeb.services.SoftgebService;

@RestController
@RequestMapping("/softgeb")
public class SoftgebController {
    
    private SoftgebService  service;

    public SoftgebController() {
        this.service = new SoftgebService();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<Softgeb> listarEquipos() {
        List<Softgeb> softgeb = new ArrayList<>();
        try {
            softgeb = service.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return softgeb;
    }
    @PostMapping
    @CrossOrigin("*")
    public String crearEquipo(@RequestBody Softgeb softgeb) {
        return service.create(softgeb);
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Softgeb consultarEquipoXid(@PathVariable int id) {
        Softgeb softgeb = new Softgeb();
        try {
            softgeb = service.readById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return softgeb;
    }

    @GetMapping("/nombre")
    @CrossOrigin("*")
    public List<Softgeb> consultarEquipoXnombre(@RequestParam String nombre_equipo) {
        List<Softgeb> softgeb = new ArrayList<>();
        try {
            softgeb = service.getByName(nombre_equipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return softgeb;
    }

   

    @PutMapping
    @CrossOrigin("*")
    public String actualizarEquipo(@RequestBody Softgeb softgeb) {
        String message = "";
        try {
            service.update(softgeb);
            message = "Los datos del equipo han sido actualizados con exito";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String delete(@PathVariable int id) {
        return service.delete(id);
    }
}
