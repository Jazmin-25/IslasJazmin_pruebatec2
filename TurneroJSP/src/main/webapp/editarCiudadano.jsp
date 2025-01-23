
<%@page import="com.softek.turnerojsp.logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- estilo de la web-->    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Edicion ciudadano</title>
    </head>
    <body>
        <div class="container mt-4">
            <h1>Formulario de modificación de ciudadanos</h1>
            <form action="EditarCiudadanoSv" method="POST"> 
                <%Ciudadano ciudad = (Ciudadano) request.getSession().getAttribute("ciudadano_editar");%>

                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%=ciudad.getNombre()%>">
                </div>  

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" value="<%=ciudad.getApellido()%>">
                </div> 

                <div class="form-group">
                    <label for="nombre">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" value="<%=ciudad.getTelefono()%>">
                </div>           

                <button type="submit" class="btn btn-primary">Modificar</button>

            </form>
        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>