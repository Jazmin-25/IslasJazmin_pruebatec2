
package com.softek.turnerojsp.servlets;

import com.softek.turnerojsp.logica.Ciudadano;
import com.softek.turnerojsp.logica.ControladoraLogica;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EditarCiudadanoSv", urlPatterns = {"/EditarCiudadanoSv"})
public class EditarCiudadanoSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id_ciudadano"));
        Ciudadano ciudad = control.buscarCiudadano(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("ciudadano_editar", ciudad);
        response.sendRedirect("editarCiudadano.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //traemos los datos  modificados del ciudadano
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        //traemos al ciudadano original sin modificar
        Ciudadano ciudad = (Ciudadano) request.getSession().getAttribute("ciudadano_editar");
        
        //modificamos los datos originales con los nuevos EN MEMORIA
        ciudad.setNombre(nombre);
        ciudad.setApellido(apellido);
        ciudad.setTelefono(telefono);
        
        control.editarCiudadano(ciudad);
        
                List<Ciudadano> listaCiudadanos = control.buscarPorApellido(apellido);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaCiudadanos", listaCiudadanos);
        
        
        response.sendRedirect("index.jsp");

    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
