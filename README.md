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
# Problemas Resueltos por el Sistema
•	Elimina la gestión manual de turnos, reduciendo errores.
•	Mejora la eficiencia en la atención ciudadana.
•	Centraliza la información para facilitar la supervisión y generación de reportes.
# Alcance del Proyecto
•	Automatizar la gestión de turnos.
•	Registrar y mantener información de ciudadanos, trámites y turnos.
# Supuestos del Sistema
- Se asume la palabra turno y no cita porque se establece un orden que permite organizar la gestión de los ciudadanos al ingresar a la entidad gubernamental para realizar un trámite especifico
- Cada turno tiene un trámite específico asociado.
- Los roles de usuario están predefinidos.
- Se asume que el sistema opera de 9:00 a.m. a 5:00 p.m. Horario dentro del cual se atiende a todos los ciudadanos que lleguen dentro del horario, por lo que no se crean citas para los días siguientes. Siendo la Secretaria de Movidad una ventana de servicio exclusiva por día.
- La fecha y hora de los turnos se almacenan como texto por simplicidad.
- Se asume la fecha y hora del turno dentro del horario laboral de 9:00 a.m. a 5:00 p.m. Por lo cual se establece el valor de fecha hora del turno como string y no como LocalDateTime
- Se asume string fecha hora del turno por términos de practicidad del ejercicio, en caso de tener que modificarlo se levantara el ticket
- Los turnos, ciudadanos y tramites no se eliminan, solo usuarios; el supervisor o administrador pueden hacerlo (sin embargo dentro del código se agregan la eliminación para fines prácticos de la demostración del CRUD). 
- Se asume que los empleados recepcionista y gestor tramite contaran con sus permisos y roles ya establecidos, por lo que no se genera el código.
- Se asume que la base de datos estar disponible siempre y cuando el sistema este en ejecución
- Se asume que el registro de la base de datos de todas las tablas será descargada en formato Excel por el administrador del sistema. Por lo cual solo se muestra la información en la base de datos.
- Se asume que los turnos tendrán dos estados: "En espera" o "Ya atendido" por lo que no se borraran los turnos, solo el administrador podrá realizarlo.
- Se asume que un ciudadano puede tener múltiples turnos, por lo que se realiza una relación uno a muchos entre ciudadano y turno.
- Se asume que un usuario puede asignar muchos turnos, por lo que se realiza una relación de uno a muchos entre usuario y turno.
# Diseño del Sistema
El sistema de turnos estará diseñado para administrar las colas de atención por día, dentro del horario de 9:00 a.m. a 5:00 p.m. El sistema está orientado a una entidad gubernamental que contará con:
1.	Un empleado recepcionista (asignador), encargado de asignar los turnos a los ciudadanos.
2.	Un empleado administrativo (gestor de trámites), quien atenderá a los ciudadanos según el orden de los turnos asignados.
3.	Un empleado supervisor (admin) que gestiona los roles de los empleados y supervisa el sistema de atención ciudadana.
# Entidades del Sistema
•	Ciudadano: Representa a la persona que solicita el turno.
•	Trámite: Representa el tipo de trámite a realizar mencionado en la descripción del caso.
•	Turno: Representa la asignación de un trámite a un ciudadano dentro del horario de atención, con un estado asociado (en espera o atendido).
•	Usuario: Representa a los usuarios del sistema. Al recepcionista que asigna los turnos (asignador), el administrativo (gestor tramite)
# Relaciones entre Entidades
-	Un ciudadano puede tener múltiples turnos: Relación uno a muchos entre ciudadano y turno.
-	Usuario - Turno: Un usuario puede asignar muchos turnos. Relación de uno a muchos entre usuario y turno.
-	Turno - Trámite: Un turno está asociado a un trámite específico. Esta es una relación de uno a uno.
