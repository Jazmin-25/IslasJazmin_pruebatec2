<%-- 
    Document   : TramiteAlta
    Created on : 22 ene 2025, 12:28:58
    Author     : zoro_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Formulario ciudadanos -->
    <h1>Registro del Turno</h1>
    <div class="container mt-4">
        <!-- Formulario alta -->
        <h2>Formulario de registro</h2>
        <form action="CiudadanoSv" method="POST">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre">
            </div>
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="apellido">
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" id="telefono" name="telefono">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>
