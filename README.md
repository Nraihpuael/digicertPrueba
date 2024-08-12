## Guía de desarrollo

### Requisitos
- GIT
https://git-scm.com/downloads
- Java 17
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Postman (para probar el endpoint)

### Instalación
1. **Bajar proyecto:**
```bash
git clone https://github.com/Nraihpuael/digicertPrueba.git
```
2. **Eliminar compilación anterior, descargar las dependencias, compilar el código y empaquetar el proyecto:** (Ejecución desde la ubicación del pom.xml)
```bash
mvnw clean package
```
3. **Levantar aplicación** (Ejecución desde la ubicación del pom.xml):
```bash
mvnw spring-boot:run
```
4. **Uso del endpoint**:
```	/api/weather

	Método: GET

	Parámetros de Consulta:
		q (Ciudad para la que deseas obtener el clima)
	
	Ejemplo
		http://localhost:8080/api/weather?q=Santa%20Cruz%20de%20la%20Sierra,bo
```
5. **Importar colección Postman**:
```
    - **Archivo de colección**: [Postman Collection](...\digicertPrueba\src\main\resources\Postman\colección.postman_collection.json)
    - **Instrucciones**:
        1. Abre Postman.
        2. Ve a la pestaña "Importar".
        3. Selecciona el archivo `colección.postman_collection.json`.
        4. Haz clic en "Abrir" y luego en "Importar".

```
6. **Json con nombre de ciudad y pais**:
```
    - **Archivo de colección**: [Postman Collection](...\digicertPrueba\src\main\resources\Cities\city.list.json) 
	Escribir nombre como parametro en el endpoint
```

### Estructura del Proyecto
```
digicertPrueba
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── digicert
    │   │           └── public_api
    │   │               ├── application
  	│	  │				        │	  ├── dto  	    --> Objetos de transferencia de datos que se utilizan para transportar datos entre las capas.
  	│   │				        │   │   └── weather --> Clases para el construir el dto. 
    │   │               │   ├── mapper      --> Facilita la transformacion de datos a dto. 
    │   │               │   └── service     --> Lógica de negocio y servicios de la aplicación. Interfaz.
    │   │               │       └── impl    --> Implementaciones de los servicios. 
    │   │               ├── infrastructure
    │   │               │   ├── config 		--> Configuraciones de la aplicación.
    │   │               │   ├── security    --> Configuracion de seguridad.
    │   │               │   └── exception   --> Manejo de excepciones.
    │   │               ├── presentation
    │   │               │   └── controller  --> API REST
    │   │               └── DigicertApplication.java
    │   ├── resources
    │   │   ├── application.properties
    │   │   ├── postman  --> Coleccion de postman.
    │   │   └── cities	 --> Nombre de ciudades para usar en la consulta.
    │   └── webapp
    └── test
        └── java
            └── com
                └── digicert
                    └── public_api
					
```		
