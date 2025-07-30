# 🧩 Spring Boot Users & Posts API

Este proyecto es una API REST desarrollada con **Spring Boot 3**, que permite gestionar usuarios y sus publicaciones. Implementa el patrón DTO para transferir datos entre capas y sigue principios de arquitectura limpia.

---

## 📦 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database (en memoria)
- Jakarta Validation
- Lombok

---

## 📌 ¿Qué es un DTO?

Un **DTO** (Data Transfer Object) es un objeto que se utiliza para transferir datos entre diferentes capas de una aplicación, como entre la capa de servicios y la de controladores. Se utiliza para:

- **Separar la lógica de negocio** de la lógica de presentación.
- **Reducir el acoplamiento** entre capas.
- **Controlar qué datos se exponen** (por ejemplo, no mostrar contraseñas).
- **Validar entradas** del cliente antes de persistir.

---

## 🧱 Diferencias entre arquitectura y patrón

| Arquitectura                  | Patrón                          |
|------------------------------|----------------------------------|
| Es el **esqueleto completo** del sistema. | Es una **solución recurrente** a un problema común. |
| Define la organización global. | Se aplica a problemas locales dentro de la arquitectura. |
| Ej: Microservicios, MVC, Hexagonal. | Ej: Singleton, DTO, Repository. |

En este proyecto usamos:

- **Arquitectura MVC** (Modelo - Vista - Controlador).
- **Patrón DTO**, para separar las entidades de la lógica de presentación.

---

## 📨 Endpoints disponibles

### 🔹 User

| Método | Endpoint       | Descripción                      |
|--------|----------------|----------------------------------|
| GET    | `/users`       | Obtener todos los usuarios.      |
| GET    | `/users/{id}`  | Obtener un usuario por ID.       |
| POST   | `/users`       | Crear un nuevo usuario.          |
| PUT    | `/users/{id}`  | Actualizar usuario por ID.       |
| DELETE | `/users/{id}`  | Eliminar usuario por ID.         |

### 📝 Post

| Método | Endpoint            | Descripción                             |
|--------|---------------------|-----------------------------------------|
| GET    | `/posts`            | Obtener todas las publicaciones.        |
| GET    | `/posts/{id}`       | Obtener una publicación por ID.         |
| GET    | `/users/{id}/posts` | Obtener posts de un usuario específico. |
| POST   | `/posts`            | Crear una nueva publicación.            |
| PUT    | `/posts/{id}`       | Actualizar una publicación.             |
| DELETE | `/posts/{id}`       | Eliminar una publicación.               |

---

## 🛠 Ejemplo de JSON

### Crear usuario

```json
POST /users
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```

### Crear post

```json
POST /posts
{
  "title": "Mi primer post",
  "content": "Contenido del post",
  "userId": 1
}
```

---

## 🧪 Base de datos

La app usa una base de datos H2 embebida. Podés acceder al panel desde:

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(vacío)*

---

## 🏁 Cómo correr el proyecto

1. Clonar el repositorio
2. Importarlo como proyecto Gradle
3. Ejecutar `DemoApplication.java`
4. Usar Postman o curl para probar los endpoints

---

## 📁 Estructura del proyecto

```
├── controller
│   └── UserController.java / PostController.java
├── service
│   └── UserService.java / PostService.java
├── entity
│   └── User.java / Post.java
├── dto
│   └── user / post
├── repository
│   └── UserRepository.java / PostRepository.java
├── mapper
│   └── UserMapper.java / PostMapper.java
└── DemoApplication.java
```

---

## 👤 Autor

- Rodrigo Zapata – [@RodrigoZ](https://github.com/tu_usuario)

---

## ✅ Licencia

Este proyecto está bajo la Licencia MIT. Podés hacer lo que quieras con él, ¡pero no te olvides de dar crédito!