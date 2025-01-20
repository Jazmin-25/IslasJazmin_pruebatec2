
package com.softek.turnerojsp.servlets;

import com.softek.turnerojsp.logica.Ciudadano;
import com.softek.turnerojsp.logica.ControladoraLogica;
import java.io.IOException;
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
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
