<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.softek.turnerojsp.logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <!-- estilo de la web-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!<!-- usuario -->
        <%
            String usu = (String) request.getSession().getAttribute("email");
            if (usu != null) {

        %>
        <p style="float: right" clas="m-4">Bienvenido <%=usu%></p>
        <!<!-- Formulario ciudadanos -->
        <h1>Registro de ciudadanos</h1>
        <div class="container mt-4">
            <!--<!-- Formulario alta -->
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

                <div class=form-group">
                    <label for="nombre">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono">
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>

            </form>

            <!--<!--Busqueda de ciudadanos -->
            <h2 class="mt-4">Busqueda de ciudadano</h2>
            <form action="CiudadanoSv" method="GET">
                <div class=form-gropu">
                    <label for="busquedaApellido">Buscar por Apellido:</label>
                    <input type="text" class="form-control" id="busquedaApellido" name="busquedaApellido">
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>  
            </form>

            <!<!-- Resultado de la busqueda -->
            <div class="results-table mt-4">
                <h2>Resultados de Busqueda</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Teléfono</th>
                        </tr>
                    </thead>        
                    <tbody>
                        <%
                            //traer la lista de ciudadanos
                            List<Ciudadano> listaCiudadanos = (List) request.getSession().getAttribute("listaCiudadanos");
                            if (listaCiudadanos != null) {
                                for (Ciudadano ciudad : listaCiudadanos) {//agregar programacion funcional al for%>
                        <tr>
                            <td><%=ciudad.getNombre()%> </td>
                            <td><%=ciudad.getApellido()%> </td>
                            <td><%=ciudad.getTelefono()%> </td>
                            <td  style="display: flex; width: 230px;"> 
                                <form name="eliminar" action="EliminarCiudadanoSv" method="POST"> <!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px; "> 
                                        <i class="fas fa-trash-alt"></i>Eliminar</button>
                                    <input type="hidden" name="id_ciudadano" value="<%=ciudad.getId()%>"> <!-- esto es para mandar el codigo al servlet -->
                                </form>
                                <!<!-- Editar ciudadano -->
                                <form name="editar" action="EditarCiudadanoSv" method="GET"> <!-- esto es para mandar el codigo al servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;"> 
                                        <i class="fas fa-pencil-alt"></i> Editar </button>
                                    <input type="hidden" name="id_ciudadano" value="<%=ciudad.getId()%>"> <!-- esto es para mandar el codigo al servlet -->
                                </form> 


                            </td>

                        </tr>
                        </tr>      
                        <%
                            }
                        %>
                    </tbody>  
                    <% }%>
                </table> 
            </div>

            <!--Eliminación de ciudadano-->  
            <h2 class="mt-4">Eliminación</h2>
            <form action="EliminarCiudadanoSv" method="POST">
                <div class="form-group">
                    <label for="id_ciudadano">Ingrese id para eliminar ciudadano</label>
                    <input type="text" class="form-control" id="id_ciudadano" name="id_ciudadano">
                </div> 

                <button type="submit" class="btn btn-primary">Eliminar</button>  
            </form>   

        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
% } 
else {
    response.sendRedirect("login.jsp");
}
%>