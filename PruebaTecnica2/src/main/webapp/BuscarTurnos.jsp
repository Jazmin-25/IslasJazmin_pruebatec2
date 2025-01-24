<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Buscar tramite -->
        <h1>Trámites pendientes</h1>
        <form action="BuscarTurnoSv" method="GET">
            <div class="form-group">
                <label for="busquedaApellido">Buscar por Apellido:</label>
                <input type="text" class="form-control" id="busquedaApellido" name="busquedaApellido">
            </div>
        </form>
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
