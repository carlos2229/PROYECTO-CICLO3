package com.hibernate.softgeb.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.EstatusModel;

public class EstatusService {
    //ATRIBUTOS
    SessionFactory factory;

    public EstatusService() {
        //Creacion del objeto factory session
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(EstatusModel.class)
                .buildSessionFactory();
    }

    //Crearmos la session
    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    //Crea un objeto tipo EstatusModel
    public List<EstatusModel> getList(){
        Session session = createSession();
        List<EstatusModel> ubicaciones = session.createQuery("FROM EstatusModel", EstatusModel.class).list();
        session.close();
        return ubicaciones;
    }

    public String create( EstatusModel estatus) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(estatus);
            session.getTransaction().commit();
            message = "Ubicacion creada con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update ( EstatusModel estatus) {
        Session session = createSession();
        //Enviar y actualizar DB
        session.merge(estatus);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(int id) {
        Session session = createSession();
        EstatusModel estatus = session.find(EstatusModel.class, id);
        deleteService(estatus);
        session.close();
        return "Ubicacion creada con exito";
    }

    public void deleteService(EstatusModel estatus) {
        Session session = createSession();
        session.remove(estatus);
        session.getTransaction().commit();
        session.close();
    }




}
