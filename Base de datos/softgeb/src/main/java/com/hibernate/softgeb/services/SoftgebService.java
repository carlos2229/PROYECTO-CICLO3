package com.hibernate.softgeb.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.Softgeb;


public class SoftgebService {

    // ATRIBUTOS
    SessionFactory factory;
    
    public SoftgebService(){
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

    public String create(Softgeb softgeb) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(softgeb);
            session.getTransaction().commit();
            message = "Equipo creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
    session.close();
    return message;
    }

    public Softgeb readById(int id) throws Exception {
        Session session = createSession();
        Softgeb softgeb = session.find(Softgeb.class, id);
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

    public List<String> objToString(List<Softgeb> objSoftgebs) {
        List<String> softgeb = new ArrayList<>();
        for(int i = 0; i < objSoftgebs.size(); i++) {
            softgeb.add(objSoftgebs.get(i).toString());
        }
        return softgeb;
    }

    public List<Softgeb> getList() throws Exception {
        Session session = createSession();
        List<Softgeb> softgeb = session.createQuery("FROM Softgeb", Softgeb.class).list();
        session.close();
        return softgeb;
    }

    public void update(Softgeb softgeb) throws Exception {
        Session session = createSession();
        // Actualizr objeto
        // Realizar actualización en la BD
        session.merge(softgeb);
        session.getTransaction().commit();
        session.close();
            
    }

    public String delete(int id) {
        Session session = createSession();
        Softgeb softgeb = session.find(Softgeb.class, id);
        deletService(softgeb); 
        return "Equipo eliminado con exito";   
    }

    public void deletService(Softgeb softgeb) {
        Session session = createSession();
        //Eliminar
        session.remove(softgeb);
        session.getTransaction().commit();
    }

}
