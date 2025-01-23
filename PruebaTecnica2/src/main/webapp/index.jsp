

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!<!-- paso 1 registrar al ciudadano -->
        <!-- Formulario ciudadanos -->
        <h1>Registro de Ciudadanos</h1>
        <div class="container mt-4">
            
            
            <!-- ALTA de ciudadano -->
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

            <!-- Busqueda de ciudadanos -->
            <h2 class="mt-4">Busqueda de ciudadano</h2>
            <form action="CiudadanoSv" method="GET">
                <div class="form-group">
                    <label for="busquedaApellido">Buscar por Apellido:</label>
                    <input type="text" class="form-control" id="busquedaApellido" name="busquedaApellido">
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>

            <!-- Resultado de la busqueda -->
            <div class="results-table mt-4">
                <h2>Resultados de Busqueda</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Teléfono</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            //List<Ciudadano> listaCiudadanos = (List) request.getSession().getAttribute("listaCiudadanos");
                            //if (listaCiudadanos != null) {
                            //  for (Ciudadano ciudad : listaCiudadanos) {
                        %>
                        <tr>

                        </tr>
                        <%
                            }
                        }
                        %>
                       
                    </body>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
