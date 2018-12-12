# Sistema Administrador de Calificaciones de Profesores
Sistema realizado como Servicio Social por parte de ESCOM para ESCA Santo Tomas.

Instalación:
- `$ npm install`
- Crea una base de datos PostgreSQL
- Ejecuta el script de creación de la base de datos que se encuentra en el archivo `./DB Scripts/DBCreationScript.sql`
- Agrega tus variables de entorno de acuerdo al archivo de ejemplo `.env.example`
- Ejecuta el script `$ npm run dev` para modo de desarrollo y `$ npm run start` para modo producción.

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
