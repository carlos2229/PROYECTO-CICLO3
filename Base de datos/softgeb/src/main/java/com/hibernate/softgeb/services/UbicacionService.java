package com.hibernate.softgeb.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.UbicacionModel;

public class UbicacionService {
    //ATRIBUTOS
    SessionFactory factory;

    public UbicacionService() {
        //Creacion del objeto factory session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(UbicacionModel.class)
                .buildSessionFactory();
    }

    //Crearmos la session
    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    //Crea un objeto tipo UbicacionModel
    public List<UbicacionModel> getList(){
        Session session = createSession();
        List<UbicacionModel> ubicaciones = session.createQuery("FROM UbicacionModel", UbicacionModel.class).list();
        session.close();
        return ubicaciones;
    }

    public String create( UbicacionModel ubicacion) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(ubicacion);
            session.getTransaction().commit();
            message = "Ubicacion creada con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update ( UbicacionModel ubicacion) {
        Session session = createSession();
        //Enviar y actualizar DB
        session.merge(ubicacion);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(int id) {
        Session session = createSession();
        UbicacionModel ubicacion = session.find(UbicacionModel.class, id);
        deleteService(ubicacion);
        session.close();
        return "Ubicacion creada con exito";
    }

    public void deleteService(UbicacionModel ubicacion) {
        Session session = createSession();
        session.remove(ubicacion);
        session.getTransaction().commit();
        session.close();
    }




}
