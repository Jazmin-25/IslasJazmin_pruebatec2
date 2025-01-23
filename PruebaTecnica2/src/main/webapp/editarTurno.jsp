
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Atención Ciudadana</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
       <!-- paso 3 gestiona turno ya atendido o espera y fin -->
        <h1>Gestión de trámite</h1>
<h3>Estatus del tramite:</h3>

<form class="user" action="EditarTurnosSv" method="POST">
    <!--numeroturno-->
    <div class="col-sm-6 mb-3">
    
    
     <!-- alta de turno -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese  el numero de turno:</label>
                <input type="text" class="form-control form-control-user" id="numeroTurno" name="numeroTurno"
                       placeholder="Número de turno (t01)" required />
            </div>

            <!--Descripción del Tramite -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese  Descripción del Tramite:</label>
                <input type="text" class="form-control form-control-user" id="tramiteDescripcion" name="tramiteDescripcion"
                       placeholder="Descripción de trámite" required />
            </div>


            <!-- Campo de ID del Ciudadano -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Ciudadano:</label>
                <input type="text" class="form-control form-control-user" id="ciudadano_id" name="ciudadano_id"
                       placeholder="ID del Ciudadano" required />
            </div>

            <!-- Campo de ID del Trámite -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Trámite:</label>
                <input type="text" class="form-control form-control-user" id="tramite_id" name="tramite_id"
                       placeholder="ID del Trámite" required />
            </div>

            <!-- Campo de ID del Usuario -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese ID Usuario:</label>
                <input type="text" class="form-control form-control-user" id="usuario_id" name="usuario_id"
                       placeholder="ID del Usuario" required />
            </div>
            
               <!-- Estadodl turno -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese la gestión del turno:</label>
                <input type="text" class="form-control form-control-user" id="estado" name="estado"
                       placeholder="Espera o Atendido" required />
            </div>
               <!-- fecha y hora -->
            <div class="col-sm-6 mb-3">
                <label for="nombre">Ingrese la fecha y hora:</label>
                <input type="text" class="form-control form-control-user" id="fechaHora" name="fechaHora "
                       placeholder="año-mes-dia hora-minuto " required />
            </div>
            
             <!--boton -->
     <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Guardar cambios
    </button>
        
             <!-- Busqueda de turno atendido -->
             <form action="EditarTurnosSv" method="GET">
            <div class="form-group">
                <label for="busquedaAtendido">Buscar tramites atendidos:</label>
                <input type="text" class="form-control" id="busquedaAtendido" name="busquedaAtendido">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>
             
             
             
             
             
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
