# Catálogo de Libros

Este proyecto es una aplicación de consola en Java que permite interactuar con un catálogo de libros. Utiliza Spring Boot, Spring Data JPA, y PostgreSQL, y consume la API de Gutendex para buscar libros.

## Requisitos

- Java 17
- Maven
- PostgreSQL

## Configuración del Proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/book-catalog.git
cd book-catalog
```

### 2. Configurar la base de datos

Asegúrate de tener PostgreSQL en funcionamiento y crea una base de datos llamada `bookcatalog`.

```sql
CREATE DATABASE bookcatalog;
```

### 3. Configurar las propiedades de la aplicación

Actualiza el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookcatalog
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Compilar y ejecutar la aplicación

```bash
mvn clean install
mvn spring-boot:run
```

### 5. Ejecutar la aplicación de consola

```bash
mvn exec:java -Dexec.mainClass="com.example.bookcatalog.console.BookCatalogConsoleApp"
```

## Uso de la Aplicación de Consola

La aplicación de consola permite las siguientes interacciones:

1. Ver todos los libros
2. Buscar un libro por ID
3. Agregar un libro
4. Eliminar un libro
5. Buscar libros por consulta
6. Salir

### 1. Ver todos los libros

Muestra todos los libros en el catálogo.

### 2. Buscar un libro por ID

Solicita el ID del libro y muestra los detalles del libro correspondiente.

### 3. Agregar un libro

Solicita el título, autor, idioma y URL de descarga del libro y lo agrega al catálogo.

### 4. Eliminar un libro

Solicita el ID del libro y lo elimina del catálogo.

### 5. Buscar libros por consulta

Solicita una consulta de búsqueda y muestra los resultados obtenidos de la API de Gutendex.

### 6. Salir

Cierra la aplicación de consola.

## Estructura del Proyecto

```plaintext
book-catalog/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/bookcatalog/
│   │   │       ├── BookCatalogApplication.java
│   │   │       ├── console/
│   │   │       │   └── BookCatalogConsoleApp.java
│   │   │       ├── controller/
│   │   │       │   └── BookController.java
│   │   │       ├── model/
│   │   │       │   └── Book.java
│   │   │       ├── repository/
│   │   │       │   └── BookRepository.java
│   │   │       └── service/
│   │   │           ├── BookService.java
│   │   │           └── GutendexResponse.java
│   │   └── resources/
│   │       └── application.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Contribuir

Si deseas contribuir a este proyecto, por favor, realiza un fork del repositorio y envía un pull request con tus cambios. Agradecemos tu colaboración.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo [LICENSE](LICENSE).
```
