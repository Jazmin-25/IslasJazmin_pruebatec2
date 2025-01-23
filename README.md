# IslasJazmin_pruebatec2
---
# Sistema de Gestión de Turnos 📋
**Automatización de la administración de turnos en Secretaría de Movilidad**

---
## 🌟 **Introducción**
El Sistema de Gestión de Turnos es una solución diseñada para automatizar la administración de turnos en una entidad gubernamental. Este sistema, desarrollado para la Secretaría de Movilidad, busca optimizar el proceso de asignación y atención a los ciudadanos, ofreciendo un servicio más eficiente y ordenado.

## 📝 **Descripción del Caso**
La Secretaría de Movilidad requiere un sistema para gestionar turnos de manera eficiente. Los trámites disponibles incluyen:
- Expedición de licencia de conducir.
- Reposición de licencia de conducir.
- Renovación de licencia de conducir.
- Corrección de datos.
- Reemplazo por vigencia

---
## ✅ **Problemas Resueltos**
- 📉 **Reducción de errores** al eliminar la gestión manual.
- 🚀 **Mejor eficiencia** en la atención ciudadana.
- 📊 **Centralización de información** para supervisión y reportes.

---
## 🎯 **Alcance del Proyecto**
1. Automatizar la gestión de turnos.
2. Registrar y mantener información de ciudadanos, trámites y turnos.

---
## 📝 **Supuestos del Sistema**
- Se asume la palabra turno y no cita porque se establece un orden que permite organizar la gestión de los ciudadanos al ingresar a la Secretaria de Movilidad para realizar un trámite especifico.
  
- Existe un super usuario que realiza todas las actividades (no se realizan permisos por simplicidad).

- Se asume que un trámite puede estar asociado a varios turnos (relación de 1 a n).
  
- Se asume que un turno solo está relacionado con un trámite específico (relación de n a 1).
  
- Se asume que un turno puede ser solicitado por un solo ciudadano (relación de n a 1).
  
- Se asume que un ciudadano puede tener varios turnos (relación de 1 a n).
  
- Se asume que un turno es atendido o gestionado por un solo usuario (relación de n a 1).
  
- Se asume que un usuario puede gestionar varios turnos (relación de 1 a n).
  
- Se asume que el sistema opera de 9:00 a.m. a 5:00 p.m. Horario dentro del cual se atiende a todos los ciudadanos que lleguen al momento, por lo que no se crean citas para los días siguientes. Siendo la Secretaria de Movidad una ventana de servicio exclusiva por día. Por lo cual se establece el valor de fecha hora del turno como string y no como LocalDateTime por simplicidad.  
    
- Se asume que la base de datos esta disponible siempre y cuando el sistema este en ejecución.
  
- Se asume que los turnos tendrán únicamente dos estados: "En espera" o "Ya atendido" por lo que no se borraran los turnos, solo se mostrara la eliminación para realizar el CRUD.

---
## 🛠️ **Diseño del Sistema**
El sistema está orientado a gestionar turnos diarios (9:00 a.m. a 5:00 p.m.), con un único super usuario.

---
## 📋 **Entidades del Sistema**
- **Ciudadano**: Persona que solicita un turno.
- **Trámite**: Tipo de trámite solicitado.
- **Turno**: Registro asignado al ciudadano y al trámite, con estado ("En espera", "Ya atendido").
- **Usuario**:Super usuario que asigna el turno y gestiona el tramite

---
## 🛠️ **Relaciones entre Entidades**
**Trámite y Turno:** 
- Un trámite puede estar asociado a varios turnos (relación de 1 a n).
- Un turno solo está relacionado con un trámite específico (relación de n a 1).

**Turno y Ciudadano:**
- Un turno puede ser solicitado por un solo ciudadano (relación de n a 1).
- Un ciudadano puede tener varios turnos (relación de 1 a n).

**Turno y Usuario:**
- Un turno es atendido o gestionado por un solo usuario (relación de n a 1).
- Un usuario puede gestionar varios turnos (relación de 1 a n).
  
**Diagrama UML:**

![Diagrama UML](https://github.com/Jazmin-25/IslasJazmin_pruebatec2/blob/main/DiagramaDefinitivoElbueno.drawio.png)

---
## 🔄 **Flujo del Sistema**
1. **Inicio de Sesión**:
- El super usuario ingresa con correo y contraseña.

2. **Registro de Turnos**:
Cuando un ciudadano llega a la Secretaría de Movilidad para realizar un trámite:
- Datos requeridos: Nombre, apellido y teléfono.
- Se registra un nuevo trámite.
- Se genera un nuevo turno asociado al trámite y al ciudadano.
3. **Gestión de Turnos**:
Visualizar la lista de turnos pendientes.
- Cambiar el estado de un turno de "En espera" a "Ya atendido".
- Buscar turnos por diferentes criterios (fecha, trámite, ciudadano).
4. **Gestión de Trámites**:
  El usuario puede:
- Crear nuevos tipos de trámites.
- Modificar información de trámites existentes.
- Eliminar trámites (teniendo en cuenta que solo es para demostrar el CRUD).
5. **Gestión de Ciudadanos**:
El usuario puede:
- Registrar nuevos ciudadanos.
- Consultar información de ciudadanos.
- Modificar información de ciudadanos.

---
## 💻 **Tecnologías Utilizadas**
- **Backend**: Java 17 + Servlets.
- **Frontend**: JSP, Bootstrap, JavaScript (vanilla).
- **Persistencia**: JPA (Java Persistence API).
- **Base de Datos**: MySQL.

---
## ⚙️ **Requisitos Técnicos**
1. Java 17 y OpenJDK.
2. Apache Tomcat como servidor de aplicaciones.
3. MySQL para la base de datos.
4. JPA y JSP para la lógica y presentación.

---
## 🚀 **Cómo Ejecutar el Sistema**
1. Instalar Apache Tomcat y configurar el proyecto.
2. Importar el esquema SQL en MySQL.
3. Iniciar sesión en Apache Tomcat con las siguientes credenciales:
   - Usuario: `admin`
   - Contraseña: `123`
4. En phpMyAdmin iniciar sesión con las siguientes credenciales:
   - Usuario: `root`
   - Contraseña: `  ` (vacio, no lleva ninguna contraseña)
6.  Probar funcionalidades principales como el registro y gestión de turnos.
7.  En caso de dudas preguntar, para recibir orientación de ejecución.
---
## 📦 **Material Entregado**
1. **Documentación**: Guía completa del sistema.
2. **Código Fuente**: Estructurado y organizado.
3. **Base de Datos**: 
   - Esquema SQL.
   - Datos de prueba.
4. **Diagrama UML**: Representación de entidades y relaciones.
---
