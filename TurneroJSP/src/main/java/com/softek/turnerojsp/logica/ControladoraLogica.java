package com.softek.turnerojsp.logica;

import com.softek.turnerojsp.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

public class ControladoraLogica {//es mi main
//genero el vinculo entre controlpersistencia y logica

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    //crearCiudadano
    public void crearCiudadano(String nombre, String apellido, String telefono) {
        // Inicio una lista vacía para los turnos, para evitar el erro
        List<Turno> listaTurnos = new ArrayList<>(); // Creamos el ciudadano con la lista vacía
        Ciudadano ciudad = new Ciudadano(null, nombre, apellido, telefono, listaTurnos);
        controlPersi.crearCiudadano(ciudad);
    }

    //mostrarCiudadano
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
        ciudadanosCoincidentes = controlPersi.buscarPorApellido(busquedaApellido);

        return ciudadanosCoincidentes;
    }

    //eliminarCiudadano
    public void eliminarCiudadano(Long id) {
        controlPersi.eliminarCiudadano(id);
    }

    public Ciudadano buscarCiudadano(Long id) {
        return controlPersi.traerCiudadano(id);
    }
    //editarCiudadano

    public void editarCiudadano(Ciudadano ciudad) {
        controlPersi.editarCiudadano(ciudad);
    }
    
    //crearusuario

    //BuscarUsuario
    public boolean validarAcceso(String email, String password) {
        Usuario usu = controlPersi.buscarUsuario(email);
        //vamos a  manipular contraseñas en texto plano lo cual no es una muy buena práctica de seguridad
        if (usu != null) {
            if (usu.getEmail().equals(email)) {
                if (usu.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

}
