package com.softek.pruebatecnica2.servlets;

import com.softek.pruebatecnica2.logica.ControladoraLogica;
import com.softek.pruebatecnica2.logica.Turno;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarTurnoSv", urlPatterns = {"/EditarTurnoSv"})
public class EditarTurnoSv extends HttpServlet {
//el jsp envia info a sv y sv llama a controladora logica

    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el parámetro de búsqueda (estado)
        String buscarEstado = request.getParameter("busquedaAtendido");
        // Validar el parámetro y realizar la búsqueda filtrando por estado en lambdas y sino tengo el especifico  traeme todos
        List<Turno> listaTurnos = control.obtenerTodosLosTurnos().stream()
                .filter(turno -> buscarEstado == null || buscarEstado.trim().isEmpty() || turno.getEstado().equalsIgnoreCase(buscarEstado))
                .collect(Collectors.toList());

        // Enviar la lista de turnos como atributo a la página JSP
        request.setAttribute("listaTurnos", listaTurnos);

        // Redirigir al JSP para mostrar los resultados
        response.sendRedirect("editarTurno.jsp");

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
