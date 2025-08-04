# Proyecto de Arquitectura DDD

Este proyecto implementa los principios de Domain-Driven Design (DDD) en una aplicación Spring Boot, enfocándose en un sistema de catálogo de libros.

## Descripción General de la Arquitectura

El proyecto sigue una arquitectura DDD en capas con la siguiente estructura:

```
src/main/java/ar/com/ddd/ddd_architecture/
├── catalog/                           # Contexto Delimitado para Catálogo
│   ├── domain/                        # Capa de Dominio
│   │   ├── models/                    # Modelos de Dominio
│   │   │   ├── BookModel.java         # Modelo de Dominio de Libro
│   │   │   └── BookInformationModel.java
│   │   ├── providers/                 # Servicios/Proveedores de Dominio
│   │   │   └── BookClientProvider.java      # Interfaces para consumir servicios externos
│   │       └── BookDAOProvider.java          # Interfaz de Acceso a Datos
│   ├── application/                   # Casos de usos
│   │   │   ├── AddBookToCatalogService.java
│   │   │   ├── GetAllBooksService.java
│   │   │   └── SaveBookService.java
│   ├── infrastructure/                # Capa de Infraestructura
│   │   ├── entity/                    # Entidades JPA
│   │   │   └── Book.java
│   │   ├── persistence/               # Implementación de Persistencia
│   │   │   ├── BookPersistenceDAO.java
│   │   │   └── impl/
│   │   │       └── BookPersistenceDAOImpl.java
│   │   ├── client/                 # Implementación de Servicios Externos
│   │   │   └── BookSearchClient.java
│   │   └── repository/                # Repositorios JPA
│   │       └── BookHibernateRepository.java
│   └── presentation/                  # Capa de Presentación
│       ├── controllers/               # Controladores REST
│       │   ├── CatalogController.java
│       │   └── impl/
│       │       └── CatalogControllerImpl.java
│       └── dto/                       # Objetos de Transferencia de Datos
│           └── BookDto.java
└── shared/                            # Shared Kernel
    └── utils/                         # Utilidades Compartidas
        └── Converter.java            # Utilidad de Mapeo de Objetos
```

## Explicación de las Capas DDD

### 1. Capa de Dominio
- Contiene la lógica de negocio central y las reglas
- Incluye modelos de dominio, interfaces de repositorio y servicios de dominio
- Los modelos representan las entidades de negocio y su comportamiento
- Define las interfaces que serán implementadas por otras capas

### 2. Capa de Aplicación
- Coordina las operaciones de negocio
- Implementa los servicios que orquestan el flujo de trabajo
- Contiene los mapeadores para transformar entre modelos de dominio y DTOs
- Ejecuta las reglas de negocio definidas en el dominio

### 3. Capa de Infraestructura
- Implementa aspectos técnicos
- Contiene entidades JPA, repositorios e implementaciones de servicios externos
- Maneja la persistencia, llamadas a APIs externas y otros detalles técnicos
- Implementa interfaces definidas en la capa de dominio

### 4. Capa de Presentación
- Maneja las peticiones y respuestas HTTP
- Contiene controladores y DTOs
- Transforma entre DTOs y modelos de dominio
- Gestiona la documentación y validación de la API

### 5. Shared Kernel
- Contiene utilidades y componentes compartidos entre contextos delimitados
- Incluye la utilidad Converter para mapeo de objetos
- Proporciona funcionalidad común utilizada por múltiples capas

## Conceptos Clave de DDD Utilizados

### Contextos Delimitados
- Catálogo: Gestiona la información de libros y operaciones del catálogo
- Cada contexto delimitado tiene sus propios modelos, repositorios y servicios

### Modelos de Dominio
- Modelos de dominio ricos con lógica de negocio
- Los modelos son independientes de las preocupaciones de infraestructura
- Ejemplo: `BookModel` representa un libro en el dominio

### Repositorios
- Abstraen el acceso a datos a través de interfaces de repositorio
- Los detalles de implementación están en la capa de infraestructura
- Ejemplo: interfaz `BookDAOProvider` con implementación `BookPersistenceDAOImpl`

### Servicios de Aplicación
- Implementan operaciones de negocio específicas
- Coordinan entre modelos de dominio y repositorios
- Ejemplo: `AddBookToCatalogService` para añadir nuevos libros

### Capa Anti-Corrupción
- Interfaz `BookClientProvider` e implementación `BookSearchClient`
- Aísla la integración de servicios externos de la lógica de dominio

## Stack Tecnológico

- Spring Boot 3.4.3
- Spring Data JPA
- Base de datos MySQL
- ModelMapper para mapeo de objetos
- Jackson para procesamiento JSON
- Swagger/OpenAPI para documentación de API

## Comenzando

1. Clonar el repositorio
2. Configurar la base de datos MySQL en `application.properties`
3. Ejecutar la aplicación usando:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acceder a la documentación de la API en: `http://localhost:8080/swagger-ui.html`
