package com.hibernate.softgeb.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.Softgeb;


public class SoftgebControlador {

    // ATRIBUTOS
    SessionFactory factory;
    
    public SoftgebControlador(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Softgeb.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public void create(String nombre_equipo, String marca, String modelo, String ubicacion, String estatus, String observacion) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Softgeb softgeb = new Softgeb(nombre_equipo, marca, modelo, ubicacion, estatus, observacion);
        session.persist(softgeb);
        session.getTransaction().commit();
        session.close();
    }

    public String readById(int id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Softgeb softgeb = session.find(Softgeb.class, id);
        session.close();
        return softgeb.toString();
    }

    public List<String> getByLastname(String nombre_equipo) throws Exception {
        //List<String> mascotas = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Softgeb> objSoftgeb = session.createQuery("from Softgeb where nombre_del_equipo = :ap", Softgeb.class)
        .setParameter("ap", nombre_equipo).list();
        session.close();
        return objToString(objSoftgeb);
        //return mascotas;
    }

    public List<String> objToString(List<Softgeb> objSoftgebs) {
        List<String> softgeb = new ArrayList<>();
        for(int i = 0; i < objSoftgebs.size(); i++) {
            softgeb.add(objSoftgebs.get(i).toString());
        }
        return softgeb;
    }

    public List<String> getList() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Softgeb> softgeb = session.createQuery("from Softgeb", Softgeb.class).list();
        session.close();
        return objToString(softgeb);
    }

    public void update(int id, String nombre_equipo, String marca, String modelo, String ubicacion, String estatus, String observacion) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Softgeb softgeb = session.find(Softgeb.class, id);
        // Actualizr objeto
        softgeb.setNombre_equipo(nombre_equipo);
        softgeb.setMarca(marca);
        softgeb.setModelo(modelo);
        softgeb.setUbicacion(ubicacion);
        softgeb.setEstatus(estatus);
        softgeb.setObservacion(observacion);
        // Realizar actualización en la BD
        session.merge(softgeb);
        session.getTransaction().commit();
        session.close();
            
    }

    public void deletService(Softgeb softgeb) {
        Session session = createSession();
        session.remove(softgeb);
        session.getTransaction().commit();
    }

    public void delete(int id) {
        Session session = createSession();
        Softgeb softgeb = session.find(Softgeb.class, id);
        deletService(softgeb);    
    }
}
