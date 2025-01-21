package com.softek.turnerojsp.logica;

import com.softek.turnerojsp.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

public class ControladoraLogica {//es mi main
//genero el vinculo entre controlpersistencia y logica

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    //metodo crud
    //crear
    public void crearCiudadano(String nombre, String apellido, String telefono) {
        // Inicio una lista vacía para los turnos, para evitar el erro
        List<Turno> listaTurnos = new ArrayList<>(); // Creamos el ciudadano con la lista vacía
        Ciudadano ciudad = new Ciudadano(null, nombre, apellido, telefono, listaTurnos);
        controlPersi.crearCiudadano(ciudad);
    }

    //filtrado en la logica opcion 1 la menos eficiente
    /*public ArrayList<Ciudadano> buscarPorApellido(String busquedaApellido) {
       ArrayList<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
        List<Ciudadano> listaCiudadanos = controlPersi.traerCiudadanos();
        
       for (Ciudadano ciudad : listaCiudadanos) {
           if (ciudad.getApellido().equals(busquedaApellido)){
               ciudadanosCoincidentes.add(ciudad);
           }
       }
       return ciudadanosCoincidentes;
    }
     */
 /*opción 2
        Paso este dato a la lógica, la lógica le pide a la persistencia que traiga SOLO LOS DATOS QUE COINCIDAN,
        y la lógica solo responde los datos ya filtrados desde la BD 
     */
    //la base de datos se encarga de traer todo filtrado
    //mostrar
    public List<Ciudadano> buscarPorApellido(String busquedaApellido) {
        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>(); //se puede hacer con programacion funcional
        ciudadanosCoincidentes = controlPersi.buscarPorApellido(busquedaApellido);

        return ciudadanosCoincidentes;
    }
//eliminar

    public void eliminarCiudadano(Long id) {
        controlPersi.eliminarCiudadano(id);
    }

    public Ciudadano buscarCiudadano(Long id) {
        return controlPersi.traerCiudadano(id);
    }
//editar

    public void editarCiudadano(Ciudadano ciudad) {
        controlPersi.editarCiudadano(ciudad);
    }

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
