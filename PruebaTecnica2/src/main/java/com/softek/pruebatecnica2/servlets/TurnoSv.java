package com.softek.pruebatecnica2.servlets;
import com.softek.pruebatecnica2.logica.ControladoraLogica;
import com.softek.pruebatecnica2.logica.Turno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {
     //el servelt se conecta con la logica mediante la controladora
    ControladoraLogica control = new ControladoraLogica();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //unicamente doy de alta para evitar errores
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numeroTurno = request.getParameter("numeroTurno");
        String tramiteDescripcion = request.getParameter("tramiteDescripcion");
        String fechaHora = request.getParameter("fechaHora");
        String estado = request.getParameter("estado");
        
        // Obtener los IDs de las entidades relacionadas
        Long ciudadanoId = Long.parseLong(request.getParameter("ciudadano_id"));
        Long tramiteId = Long.parseLong(request.getParameter("tramite_id"));
        Long usuarioId = Long.parseLong(request.getParameter("usuario_id"));

        control.crearTurnos(numeroTurno, tramiteDescripcion, fechaHora, estado, ciudadanoId, tramiteId, usuarioId);

        response.sendRedirect("index.jsp");

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
