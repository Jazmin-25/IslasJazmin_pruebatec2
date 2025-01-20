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

@WebServlet(name = "EliminarCiudadanoSv", urlPatterns = {"/EliminarCiudadanoSv"})
public class EliminarCiudadanoSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id_ciudadano"));
        //buscar a la persona en la bd por la id
        Ciudadano ciudad = control.buscarCiudadano(id);
        String apellido = ciudad.getApellido();
        control.eliminarCiudadano(id);

        //un get para traer su apellido        
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