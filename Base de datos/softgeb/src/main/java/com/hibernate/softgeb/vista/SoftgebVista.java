package com.hibernate.softgeb.vista;

import javax.swing.JOptionPane;
import java.util.List;
import com.hibernate.softgeb.controlador.SoftgebControlador;

public class SoftgebVista {
    
    private SoftgebControlador controlador;

    public SoftgebVista() {
        controlador = new SoftgebControlador();
    }

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void crearEquipo() {
        //Solicitar datos
        String nombre_equipo = JOptionPane.showInputDialog(null, "Ingrese nombre de la maquina: ");
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del equipo: ");
        String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del equipo: ");
        String ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicación actual del equipo: ");
        String estatus = JOptionPane.showInputDialog(null, "Estado actual del equipo: ");
        String observacion = JOptionPane.showInputDialog(null, "Observación");

        // Enviar datos al controlador
        try {
            controlador.create(nombre_equipo, marca, modelo, ubicacion, estatus, observacion);
            mostrarMensaje("Equipo registrado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }

    }

    public void consultarEquipoXid() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el identificador del equipo"));
        try {
            String info = controlador.readById(id);
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
        
    }

    
    public void consultarEquipoXnombre() {
        String nombre_equipo = JOptionPane.showInputDialog(null, "Por favor ingrese el nombre del equipo");
        try {
            List<String> softgeb = controlador.getByLastname(nombre_equipo);
            String info = lisToString(softgeb);
            mostrarMensaje(info);
            
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    }

    public String lisToString(List<String> list) {
        String info = "-----------------EQUIPOS EN INVENTARIO-----------------";
        for(int i = 0; i < list.size(); i++) {
            info += list.get(i);
        }
        return info;
    }

    public void listarEquipos() {
        try {
            List<String> softgeb = controlador.getList();
            String info = lisToString(softgeb);
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    }

    public void actualizarEquipo() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el identificador del equipo"));
        String nombre_equipo = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del equipo: ");
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del equipo: ");
        String modelo = JOptionPane.showInputDialog(null, "Ingrese modelo del equipo: ");
        String ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicacion del equipo: ");
        String estatus = JOptionPane.showInputDialog(null, "Ingrese el estatus actual del equipo: ");
        String observacion = JOptionPane.showInputDialog(null, "Observación");
        try {
            controlador.update(id, nombre_equipo, marca, modelo, ubicacion, estatus, observacion);
            mostrarMensaje("Los datos del equipo han sido actualizados con exito");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    
    }

    public void eliminarEquipo(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ELIMINAR EQUIPO\nPor favor ingrese el identificador del equipo"));
        controlador.delete(id);
        mostrarMensaje("Equipo eliminada con éxito");
    }

    public void menu() {
        String info = "1) Registro de equipo\n";
        info += "2) Consultar equipo por id\n";
        info += "3) Consultar equipo por nombre\n";
        info += "4) Actualizar informacion del equipo\n";
        info += "5) Eliminar equipo\n";
        info += "6) Listar equipos\n";
        info += "-1) Salir\n";

        int opc = 0;
        while(opc != -1) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, info));
            switch (opc) {
                case 1:
                    crearEquipo();
                    break;
                case 2:
                    consultarEquipoXid();
                    break;
                case 3:
                    consultarEquipoXnombre();
                    break;
                case 4:
                    actualizarEquipo();
                    break;
                case 5:
                    eliminarEquipo();
                    break;
                case 6:
                    listarEquipos();
                    break;
                case -1:
                    break;
                default:
                    mostrarMensaje("Por favor ingrese una opción válida");
                    break;
            }
        }
    }
}
