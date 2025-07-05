# Proyecto Final - Desarrollo de Sistemas de la Información

## Contexto del Proyecto

Estoy trabajando en un proyecto final para la materia "Desarrollo de Sistemas de la Información" de la facultad. Este documento describe los requisitos y el alcance del sistema que debo desarrollar.

**ATENCIÓN, GEMINI CLI:**

**No realices ningún cambio en este documento ni generes código automáticamente a menos que yo te lo pida explícitamente. Mi intención es que actúes como guía, me brindes sugerencias, y me ayudes a resolver consultas específicas sobre este proyecto. Considera este documento como una especificación de requisitos.**

---

## Tecnologías Utilizadas

Para el desarrollo de este proyecto, estamos utilizando las siguientes tecnologías:

* **Java 21**
* **Spring Boot** (con `spring-boot-devtools`, `spring-boot-starter-web`, `spring-boot-starter-data-jpa`)
* **MySQL** (como base de datos)
* **Thymeleaf** (para la capa de presentación/vistas)
* **ModelMapper** (para mapeo de objetos)

---

## Funcionalidad Principal: Gestión de Entrega de Raciones

El objetivo principal del proyecto es realizar las operaciones de Alta, Baja, Modificación y Eliminación (CRUD) sobre la "entrega de raciones" en un centro de asistencia.

### Epic Asignado

**"Como voluntario de un centro de asistencia, quiero poder gestionar las entregas de alimentos a las familias para llevar un registro preciso de la asistencia brindada y el control de stock."**

---

### Historias de Usuario

A continuación se detallan las historias de usuario y sus criterios de aceptación:

#### 1. Registrar una Entrega de Alimentos (Alta)

* **Como** voluntario de un centro de asistencia,
* **Quiero** poder registrar la entrega de alimentos a una familia,
* **Para** dejar registro de la asistencia brindada.

**Criterios de Aceptación:**
* El usuario debe poder ingresar los siguientes datos:
    * `nro de familia` (entero positivo)
    * `preparacion` (lista de selección de las comidas preparadas en el día)
    * `cantidad de raciones a entregar` (número entero positivo)
* Una vez dada de alta la entrega, se debe proceder a dar de baja del stock las raciones entregadas.
* El sistema guardará automáticamente la fecha de entrega (fecha actual).
* No podrá haber dos entregas en el mismo día para la misma familia.
* No se puede entregar más raciones que integrantes registrados para la familia.

---

#### 2. Dar de Baja una Entrega de Alimentos (Eliminación/Reversión)

* **Como** voluntario de un centro de asistencia,
* **Quiero** poder dar de baja una entrega de alimentos registrada por error,
* **Para** poder eliminar un registro mal cargado y volver atrás esa baja de stock de raciones.

**Criterios de Aceptación:**
* Una vez eliminada la entrega, el stock correspondiente vuelve a estar disponible para ser entregado a otra familia.

---

#### 3. Listar y Filtrar Entregas Realizadas (Consulta)

* **Como** voluntario de un centro de asistencia,
* **Quiero** poder listar las entregas realizadas en un día en particular,
* **Para** poder buscar una entrega y proceder a la eliminación de la misma, o simplemente saber qué se entregó en el día y a quién.

**Criterios de Aceptación:**
* Se presentará un listado con todas las entregas realizadas en el día.
* El listado constará de las siguientes columnas:
    * `número de familia`
    * `nombre de familia`
    * `preparación entregada`
    * `número de raciones entregadas`
* El listado presentará los accesos para eliminar una entrega (cuya funcionalidad fue descripta en la historia de usuario anterior).
* Se podrá filtrar el listado por `fecha`, `número de familia` y `nombre de familia`.