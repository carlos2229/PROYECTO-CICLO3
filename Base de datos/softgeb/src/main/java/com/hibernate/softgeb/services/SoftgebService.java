package com.hibernate.softgeb.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.Estatus;
import com.hibernate.softgeb.modelo.Softgeb;
import com.hibernate.softgeb.modelo.Ubicacion;


public class SoftgebService {

    // ATRIBUTOS
    SessionFactory factory;
    
    public SoftgebService(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Softgeb.class)
        .addAnnotatedClass(Ubicacion.class)
        .addAnnotatedClass(Estatus.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String create(Softgeb equipos) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(equipos);
            session.getTransaction().commit();
            message = "Equipo creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
    session.close();
    return message;
    }

    public Softgeb readById(int idequipos) throws Exception {
        Session session = createSession();
        Softgeb softgeb = session.find(Softgeb.class, idequipos);
        session.close();
        return softgeb;
    }

    public List<Softgeb> getByName(String nombre_equipo) throws Exception {
        Session session = createSession();
        List<Softgeb> objSoftgebs = session.createQuery("FROM Softgeb WHERE nombre_equipo = :n", Softgeb.class)
        .setParameter("n", nombre_equipo).list();
        session.close();
        return objSoftgebs;
        // return mascotas;
    }

    //  public List<String> objToString(List<Softgeb> objSoftgebs) {
    //     List<String> equipos = new ArrayList<>();
    //     for(int i = 0; i < objSoftgebs.size(); i++) {
    //         equipos.add(objSoftgebs.get(i).toString());
    //     }
    //     return equipos;
    // }

    public List<Softgeb> getList() throws Exception {
        Session session = createSession();
        List<Softgeb> equipos = session.createNativeQuery("selec * from equipos", Softgeb.class).list();
        session.close();
        return equipos;
    }

    public void update(Softgeb equipos) throws Exception {
        Session session = createSession();
        // Actualizr objeto
        // Realizar actualización en la BD
        session.merge(equipos);
        session.getTransaction().commit();
        session.close();
            
    }

    public String delete(int id) {
        Session session = createSession();
        Softgeb equipos = session.find(Softgeb.class, id);
        deletService(equipos); 
        return "Equipo eliminado con exito";   
    }

    public void deletService(Softgeb equipos) {
        Session session = createSession();
        //Eliminar
        session.remove(equipos);
        session.getTransaction().commit();
    }

}
