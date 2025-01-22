<%-- 
    Document   : GestionUsuarios
    Created on : 22 ene 2025, 12:52:43
    Author     : zoro_
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Usuarios: </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Formulario alta usuario -->
        <h2>Formulario de registro</h2>
        <form action="UsuarioSv" method="POST">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="password:">Password:</label>
                <input type="text" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
        
        <!-- Busqueda usuario -->
        <h2 class="mt-4">Busqueda de usuario</h2>
        <form action="UsuarioSv" method="GET">
            <div class="form-group">
                <label for="busquedaCorreo">Buscar por correo:</label>
                <input type="text" class="form-control" id="busquedaCorreo" name="busquedaCorreo">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>
        
            <!-- Resultado de la busqueda -->
        <div class="results-table mt-4">
            <h2>Resultados de Busqueda</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Correo</th>
                        <th>Contraseña</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Usuario> listaCiudadanos = (List) request.getSession().getAttribute("listaUsuarios");
                        if (listaCiudadanos != null) {
                            for (Usuario usu : listaUsuarios) {
                    %>
                    <tr>
                        <td><%= usu.getCorreo() %></td>
                        <td><%= usu.getPassword:() %></td>
                        <td style="display: flex; width: 230px;">
                            <form name="eliminar" action="EliminarCiudadanoSv" method="POST">
                                <input type="hidden" name="id_ciudadano" value="<%= ciudad.getId() %>">
                                <button type="submit" class="btn btn-danger">Eliminar</button>
                            </form>
                            <form name="editar" action="EditarCiudadanoSv" method="GET" style="margin-left: 5px;">
                                <input type="hidden" name="id_ciudadano" value="<%= ciudad.getId() %>">
                                <button type="submit" class="btn btn-warning">Editar</button>
                            </form>
                        </td>
                    </tr>
                     <--<!-- Se genera autimaticamente el numero de turno, en mi backen tengo que llamar al numeroTurno -->
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        
    </body>
</html>
