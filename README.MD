# CRUD Client - Spring Boot Java 21

Este proyecto es una aplicación CRUD básica para gestionar clientes, usando Spring Boot 3.2.5, Java 21 y H2 como base de datos en memoria. Está diseñado para demostrar:

* Uso de Records en Java
* Pattern Matching con tipos
* Manejo de errores y logs
* Documentación OpenAPI en YAML
* Pruebas unitarias básicas

---

## Tecnologías Utilizadas

* Java 21
* Spring Boot 3.2.5
* Maven
* H2 Database
* SpringDoc OpenAPI
* JUnit

---

## Requisitos

* Java 21 instalado y configurado
* Maven instalado y configurado (revisar con `mvn -v`)

---

## Ejecución del Proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/jalducin/crud-client.git
cd crud-client
```

2. Ejecutar desde terminal:

```bash
mvn clean install
mvn spring-boot:run
```

La aplicación se ejecutará en `http://localhost:8082`

---

## Base de Datos

Se utiliza H2 en memoria. Al arrancar el proyecto se crea automáticamente una tabla `Cliente`.

Para acceder a la consola:

* `http://localhost:8082/h2-console`
* JDBC URL: `jdbc:h2:mem:testdb`
* Usuario: `sa`
* Contraseña: (dejar en blanco)

---

## Endpoints API (Postman)

### 1. Obtener todos los clientes

```
GET http://localhost:8082/api/clientes
```

### 2. Crear cliente

```
POST http://localhost:8082/api/clientes
Content-Type: application/json
{
  "id": "001",
  "nombre": "Juan Perez",
  "email": "juan@example.com",
  "edad": 30,
  "tipoCliente": "VIP"
}
```

### 3. Actualizar cliente

```
PUT http://localhost:8082/api/clientes/001
Content-Type: application/json
{
  "id": "001",
  "nombre": "Juan Actualizado",
  "email": "nuevo@example.com",
  "edad": 31,
  "tipoCliente": "REGULAR"
}
```

### 4. Eliminar cliente

```
DELETE http://localhost:8082/api/clientes/001
```

---

## Documentación OpenAPI

Disponible en:

```
http://localhost:8082/swagger-ui/index.html
```

---

## Pruebas Unitarias

Ejecutar:

```bash
mvn test
```

Resultado esperado:

* Al menos 1 prueba ejecutada sin errores.

---

## Subir a GitHub

```bash
git init
git add .
git commit -m "Primer commit funcional CRUD Cliente"
git branch -M main
git remote add origin https://github.com/jalducin/crud-client.git
```git remote set-url origin https://github.com/jalducin/crud-client.git
git push -u origin main
```

---

## Autor

Juan Valentín Alducín Vázquez

---

Listo para integrarse con Docker, Jenkins o Kubernetes como parte de una arquitectura de microservicios.
