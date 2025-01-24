
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.softek.pruebatecnica2.logica.Turno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Gestión de trámite -->
        <h1>Gestión de trámite</h1>
        <h3>Estatus del trámite:</h3>

        <!-- Formulario para guardar cambios -->
        <form class="user" action="EditarTurnoSv" method="POST">
            <!-- Número de turno -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese el número de turno:</label>
                <input type="text" class="form-control form-control-user" id="numeroTurno" name="numeroTurno"
                       placeholder="Número de turno (t01)" required />
            </div>

            <!-- Descripción del Trámite -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese Descripción del Trámite:</label>
                <input type="text" class="form-control form-control-user" id="tramiteDescripcion" name="tramiteDescripcion"
                       placeholder="Descripción de trámite" required />
            </div>

            <!-- ID del Ciudadano -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Ciudadano:</label>
                <input type="text" class="form-control form-control-user" id="ciudadano_id" name="ciudadano_id"
                       placeholder="ID del Ciudadano" required />
            </div>

            <!-- ID del Trámite -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Trámite:</label>
                <input type="text" class="form-control form-control-user" id="tramite_id" name="tramite_id"
                       placeholder="ID del Trámite" required />
            </div>

            <!-- ID del Usuario -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Usuario:</label>
                <input type="text" class="form-control form-control-user" id="usuario_id" name="usuario_id"
                       placeholder="ID del Usuario" required />
            </div>

            <!-- Estado del turno -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese la gestión del turno:</label>
                <input type="text" class="form-control form-control-user" id="estado" name="estado"
                       placeholder="Espera o Atendido" required />
            </div>

            <!-- Fecha y hora -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese la fecha y hora:</label>
                <input type="text" class="form-control form-control-user" id="fechaHora" name="fechaHora"
                       placeholder="año-mes-día hora-minuto " required />
            </div>

            <!-- Botón -->
            <button class="btn btn-primary btn-user btn-block" type="submit"> 
                Guardar cambios
            </button>
        </form>

        <!-- Formulario para buscar turnos atendidos -->
        <form action="EditarTurnoSv" method="GET">
            <div class="form-group mt-4">
                <label for="busquedaAtendido">Buscar trámites atendidos:</label>
                <input type="text" class="form-control" id="busquedaAtendido" name="busquedaAtendido">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>

        <!-- Resultados de la búsqueda -->
        <div class="results-table mt-4">
            <h2>Resultados de Búsqueda</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Número de turno</th>
                        <th>Descripción del Trámite</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        // Validar si la lista no es nula
                        List<Turno> listaTurnos = (List<Turno>) request.getAttribute("listaTurnos");
                        if (listaTurnos != null && !listaTurnos.isEmpty()) {
                            for (Turno turno : listaTurnos) { 
                    %>
                        <tr>
                            <td><%= turno.getNumeroTurno() %></td>
                            <td><%= turno.getTramiteDescripcion() %></td>
                            <td><%= turno.getEstado() %></td>
                        </tr>
                    <% 
                            }
                        } else { 
                    %>
                        <tr>
                            <td colspan="3" class="text-center">No se encontraron resultados</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- Scripts -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>