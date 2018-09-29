# ServicioSocial
Servicio social ESCA Santo Tomas


Instructions
- `$ npm install`
- Add your own `.env` file according to the `.env.example` file

## El sistema está modulizado por jerarquias y debido a su naturaleza web esta dividido en cliente y servidor.

- Cliente:
	- Pagina principal
	- Sesión
	- Curso
	- Periodo
	- Busqueda por profesor
	- Carga de documentos

- Servidor (Servicios):
	- Autenticacion
	- Calificaciones
	- Cursos
	- Carga de datos
	- Materias
	- Periodos
	- Personas
	- Busquedas
	- Información de usuario


Cuenta con 12 tablas relacionales en base de datos.
Y un sistema de administración de archivos para la carga de documentos adjuntos.
