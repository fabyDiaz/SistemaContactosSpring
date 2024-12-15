## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

1. **Java Development Kit (JDK)** - Versión 11 o superior.
2. **Apache Maven** - Para construir y ejecutar la aplicación.
3. **MySQL Server** - Base de datos para almacenar la información.

---

## Configuración de MySQL

1. Instala y configura MySQL Server en tu máquina.  
   Si no tienes MySQL instalado, puedes descargarlo desde:  
   [https://dev.mysql.com/downloads/](https://dev.mysql.com/downloads/)

2. Crea una base de datos llamada `contactos_db` o permite que se cree automáticamente.

3. Configura tus credenciales de acceso en el archivo `.env`:

   ```plaintext
   DB_URL=jdbc:mysql://localhost:3306/contactos_db?createDatabaseIfNotExist=true
   DB_USERNAME=tu_usuario_mysql
   DB_PASSWORD=tu_contraseña_mysql
