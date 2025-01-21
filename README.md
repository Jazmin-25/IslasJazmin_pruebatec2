# IslasJazmin_pruebatec2
# Sistema de Gestión de Turnos 📋
**Automatización de la administración de turnos en entidades gubernamentales**

---
## 🌟 **Introducción**
El Sistema de Gestión de Turnos es una solución diseñada para automatizar la administración de turnos en una entidad gubernamental. Este sistema, desarrollado para la Secretaría de Movilidad, busca optimizar el proceso de asignación y atención a los ciudadanos, ofreciendo un servicio más eficiente y ordenado.

## 📝 **Descripción del Caso**
La Secretaría de Movilidad requiere un sistema para gestionar turnos de manera eficiente. Los trámites disponibles incluyen:
- Expedición de licencia de conducir.
- Reposición de licencia de conducir.
-Renovación de licencia de conducir.
-Corrección de datos.
-Reemplazo por vigencia

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
- Se asume la palabra turno y no cita porque se establece un orden que permite organizar la gestión de los ciudadanos al ingresar a la Secretaria de Movilidad para realizar un trámite especifico
- Los roles de usuario están predefinidos por la Secretaria de Movilidad, el unico que asigna los roles es el supervisor (no se realizan permisos por simplicidad). 
- Se asume que cada turno tiene un trámite específico asociado.
- Se asume que un ciudadano puede tener múltiples turnos, por lo que se realiza una relación uno a muchos entre ciudadano y turno.
- Se asume que un usuario puede asignar muchos turnos, por lo que se realiza una relación de uno a muchos entre usuario y turno.
- Se asume que el sistema opera de 9:00 a.m. a 5:00 p.m. Horario dentro del cual se atiende a todos los ciudadanos que lleguen al momento, por lo que no se crean citas para los días siguientes. Siendo la Secretaria de Movidad una ventana de servicio exclusiva por día
- La fecha y hora de los turnos se almacenan como texto por simplicidad.
- Se asume la fecha y hora del turno dentro del horario laboral de 9:00 a.m. a 5:00 p.m. Por lo cual se establece el valor de fecha hora del turno como string y no como LocalDateTime por simplicidad.
- Se asume string fecha hora del turno por términos de practicidad del ejercicio, en caso de tener que modificarlo se levantara el ticket
- Los turnos, ciudadanos y tramites no se eliminan, solo usuarios; el supervisor o administrador pueden hacerlo (sin embargo dentro del código se agregan la eliminación para fines prácticos de la demostración del CRUD). 
- Se asume que los empleados recepcionista y gestor tramite contaran con sus permisos y roles ya establecidos, por lo que no se genera permisos en el código por simplicidad.
- Se asume que la base de datos estar disponible siempre y cuando el sistema este en ejecución
- Se asume que el registro de la base de datos de todas las tablas será descargada en formato Excel por el administrador del sistema. Por lo cual solo se muestra la información en la base de datos.
- Se asume que los turnos tendrán dos estados: "En espera" o "Ya atendido" por lo que no se borraran los turnos, solo el administrador podrá realizarlo.

---
## 🛠️ **Diseño del Sistema**
El sistema está orientado a gestionar turnos diarios (9:00 a.m. a 5:00 p.m.), con los siguientes roles:

1. **Recepcionista (asignador)**: Asigna turnos a los ciudadanos.
2. **Gestor de trámites (administrativo)**: Atiende a los ciudadanos en el orden asignado.
3. **Supervisor (admin)**: Gestiona roles y supervisa el sistema.

---
## 📋 **Entidades del Sistema**
- **Ciudadano**: Persona que solicita un turno.
- **Trámite**: Tipo de trámite solicitado.
- **Turno**: Registro asignado al ciudadano y al trámite, con estado ("En espera", "Ya atendido").
- **Usuario**: Empleado con roles predefinidos (recepcionista, administrativo, supervisor).

---
## 🛠️ **Relaciones entre Entidades**
-	Un ciudadano puede tener múltiples turnos: Relación uno a muchos entre ciudadano y turno.
-	Usuario - Turno: Un usuario puede asignar muchos turnos. Relación de uno a muchos entre usuario y turno.
-	Turno - Trámite: Un turno está asociado a un trámite específico. Esta es una relación de uno a uno.

---
## 🔄 **Flujo del Sistema**
1. **Inicio de Sesión**:
- Cada usuario ingresa con correo y contraseña.
- Los usuarios son:
- Recepcionista (asignador): Encargado de registrar turnos.
- Administrativo (gestor de trámites): Responsable de atender a los ciudadanos.
- Supervisor (admin): Encargado de la gestión y supervisión general del sistema.

---
2. **Registro de Turnos**:
Cuando un ciudadano llega a la Secretaria de Movilidad para realizar un trámite, el recepcionista lo registra:
- Datos requeridos: Nombre, apellido y teléfono del ciudadano.
   - Generación automática de un número de turno.
4. **Gestión de Turnos**:
En la pantalla del sistema, el gestor de trámites podrá visualizar la fila de turnos asignados por el recepcionista.
- Estados: "En espera" y "Ya atendido".
- Gestión en tiempo real por el administrativo.
5. **Gestión de Usuarios**:
- Creación de nuevos usuarios con roles específicos por el supervisor.

---
## 💻 **Tecnologías Utilizadas**
- **Backend**: Java 17 + Servlets.
- **Frontend**: JSP, Bootstrap, JavaScript.
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
3. Iniciar sesión en Apache Tomca con las siguientes credenciales:
   - Usuario: `admin`
   - Contraseña: `123`
4. En phpMyAdmin iniciar sesión con las siguientes credenciales:
   - Usuario: `root`
   - Contraseña: `  ` (vacio, no lleva ninguna contraseña)
6.  Probar funcionalidades principales como el registro y gestión de turnos.
---
## 📦 **Material Entregado**
1. **Documentación**: Guía completa del sistema.
2. **Código Fuente**: Estructurado y organizado.
3. **Base de Datos**: 
   - Esquema SQL.
   - Datos de prueba.
4. **Diagrama UML**: Representación de entidades y relaciones.

---
