API REST de Autenticación de Usuarios

API REST desarrollada con Java y Spring Boot para registrar usuarios e iniciar sesión.

Tecnologías

Java

Spring Boot

Spring Data JPA

MySQL

Maven

Postman para pruebas

Requisitos previos

Java compatible con la versión del proyecto.

MySQL en ejecución.

Git.

Visual Studio Code u otro editor.

Postman para probar los endpoints.

Configuración de la base de datos

Crea en MySQL una base de datos llamada autenticacion.

Configura las credenciales de conexión mediante las propiedades locales del proyecto.

No subas la contraseña de la base de datos a GitHub ni la escribas en este README.

Si el proyecto utiliza la variable de entorno DB_PASSWORD, configúrala en Git Bash para la sesión actual:

export DB_PASSWORD='TU_CONTRASEÑA_REAL'

Reemplaza el texto de ejemplo por tu contraseña real. No compartas ni publiques ese valor.

Cómo ejecutar la API

Abre Git Bash en la carpeta raíz del proyecto.

Configura DB_PASSWORD si el proyecto la requiere.

Ejecuta:

./mvnw spring-boot:run

Espera a que Spring Boot indique que la aplicación se inició correctamente.

Mantén abierta la terminal mientras utilizas la API.

Dirección base local:

http://localhost:8080

Endpoints disponibles

1. Registrar usuario

Método: POST

URL: http://localhost:8080/api/usuarios/registro

Descripción: registra un usuario nuevo.

En Postman, selecciona Body > raw > JSON y envía:

{
  "nombre": "Carlos",
  "apellido": "Perez",
  "correo": "carlos.prueba@example.com",
  "password": "PruebaSegura123"
}

Respuestas esperadas:

201 Created: usuario registrado correctamente.

409 Conflict: el correo ya está registrado.

400 Bad Request: los datos enviados no son válidos.

2. Iniciar sesión

Método: POST

URL: http://localhost:8080/api/usuarios/login

Descripción: verifica las credenciales del usuario.

En Postman, selecciona Body > raw > JSON y envía:

{
  "correo": "carlos.prueba@example.com",
  "password": "PruebaSegura123"
}

Respuestas esperadas:

200 OK: autenticación satisfactoria.

401 Unauthorized: error de autenticación cuando el correo no existe o la contraseña es incorrecta.

Los códigos y mensajes indicados son los resultados esperados según el diseño del proyecto. Confirma que coincidan con las respuestas reales de la aplicación.

Probar con Postman

Ejecuta la API.

Crea una solicitud nueva en Postman.

Selecciona el método POST.

Copia la URL del endpoint.

Entra en Body > raw > JSON.

Pega el JSON del caso.

Pulsa Send y revisa el código HTTP y el cuerpo de la respuesta.

Casos recomendados:

Registrar un usuario con un correo nuevo.

Intentar registrarlo otra vez con el mismo correo.

Intentar registrar un usuario con campos vacíos.

Iniciar sesión con las credenciales correctas.

Iniciar sesión con una contraseña incorrecta.

Iniciar sesión con un correo inexistente.

Seguridad

No publiques contraseñas reales, tokens ni credenciales de la base de datos.

No incluyas contraseñas en las respuestas de la API.

Utiliza contraseñas de prueba para las demostraciones.

En un entorno real, utiliza HTTPS y una configuración de seguridad adecuada.

Autor

David Barranco — Tecnología en Análisis y Desarrollo de Software (ADSO).