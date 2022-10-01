package com.hibernate.softgeb.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.softgeb.modelo.EstatusModel;
import com.hibernate.softgeb.modelo.EquipoModel;
import com.hibernate.softgeb.modelo.UbicacionModel;


public class EquipoService {

    // ATRIBUTOS
    SessionFactory factory;
    public EquipoService(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(EquipoModel.class)
        .addAnnotatedClass(UbicacionModel.class)
        .addAnnotatedClass(EstatusModel.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }
    
    public List<EquipoModel> getList() throws Exception {
        Session session = createSession();
        List<EquipoModel> equipos = session.createQuery("FROM EquipoModel", EquipoModel.class).list();
        session.close();
        return equipos;
    }

    public EquipoModel readById(int idequipos) throws Exception {
        Session session = createSession();
        EquipoModel softgeb = session.find(EquipoModel.class, idequipos);
        session.close();
        return softgeb;
    }

    //Crear Equipo
    public String create(EquipoModel equipos) {
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

    

    public List<EquipoModel> getByName(String nombre_equipo) throws Exception {
        Session session = createSession();
        List<EquipoModel> objSoftgebs = session.createQuery("FROM EquipoModel WHERE nombre_equipo = :n", EquipoModel.class)
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


    public void update(EquipoModel equipos) throws Exception {
        Session session = createSession();
        // Actualizr objeto
        // Realizar actualización en la BD
        session.merge(equipos);
        session.getTransaction().commit();
        session.close();
            
    }

    public String delete(int id) {
        Session session = createSession();
        EquipoModel equipos = session.find(EquipoModel.class, id);
        deletService(equipos); 
        return "Equipo eliminado con exito";   
    }

    public void deletService(EquipoModel equipos) {
        Session session = createSession();
        //Eliminar
        session.remove(equipos);
        session.getTransaction().commit();
    }

}
