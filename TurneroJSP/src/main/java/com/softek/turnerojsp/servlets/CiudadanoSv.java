
package com.softek.turnerojsp.servlets;
import com.softek.turnerojsp.logica.Ciudadano;
import com.softek.turnerojsp.logica.ControladoraLogica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {
    //el servelt se conecta con la logica mediante la controladora
    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String busquedaApellido = request.getParameter("busquedaApellido");
        //opcion 1 paso el dato a la logica y filtra
        ArrayList<Ciudadano> listaCiudadanos = control.buscarPorApellido(busquedaApellido);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaCiudadanos", listaCiudadanos);
        response.sendRedirect("index.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        //metodo de logica
        control.crearCiudadano(nombre, apellido, telefono);
        //cuando termine el alta, me regresa otra vez al index
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}