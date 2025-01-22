<%-- 
    Document   : GestionTurno
    Created on : 22 ene 2025, 12:42:33
    Author     : zoro_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Turnos: </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Gestión de Turnos</h1>
        <div class="turno-container" id="turno1">
        <div class="turno-info">
            <p><strong>Turno ID:</strong> 1</p>
            <p><strong>Trámite:</strong> Licencia de Conducir</p>
            <p><strong>Ciudadano:</strong> Juan Pérez</p>
            <p><strong>Estado:</strong> <span id="estado-turno1">En espera</span></p>
        </div>
        <div class="buttons">
            <button class="btn btn-atendido" onclick="marcarComoAtendido(1)">Marcar como Atendido</button>
            <button class="btn btn-espera" onclick="marcarComoEspera(1)">Cambiar a En Espera</button>
        </div>
    </div>
        <!-- Busqueda turnos en espera y ya yatendido -->
        <!<!-- se hara una lista donde se muestren los atendidos y los que estan en espera -->
        <h2 class="mt-4">Busqueda de ciudadano</h2>
        <form action="GestionTurnoSv" method="GET">
            <div class="form-group">
                <label for="busquedaTurno">Buscar Turno</label>
                <input type="text" class="form-control" id="busquedaTurno" name="busquedaTurno">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>

        
        
    <script>
        // Función para marcar un turno como "Ya atendido"
        function marcarComoAtendido(turnoId) {
            const estadoSpan = document.getElementById(`estado-turno${turnoId}`);
            estadoSpan.textContent = "Ya atendido";

            // Simulación de llamada a backend
            console.log(`Turno ${turnoId} marcado como atendido.`);
        }

        // Función para marcar un turno como "En espera"
        function marcarComoEspera(turnoId) {
            const estadoSpan = document.getElementById(`estado-turno${turnoId}`);
            estadoSpan.textContent = "En espera";

            // Simulación de llamada a backend
            console.log(`Turno ${turnoId} marcado como en espera.`);
        }
        
    </script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
