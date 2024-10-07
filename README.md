# PruebaJava8

## Descripción
Este proyecto es una aplicación web de gestión de tareas desarrollada con Java 8 y Spring Boot MVC. Utiliza la arquitectura MVC (Modelo-Vista-Controlador) para organizar la lógica de la aplicación, separando claramente la interacción con la base de datos, la lógica de negocio y la presentación de las vistas al usuario. Permite registrar tareas con nombre, descripción y fecha de inicio, además de listar las tareas creadas. El proyecto se encuentra dividido en dos módulos: el principal (`PruebaJava`) y un módulo separado (`datos - module`) que maneja la conexión a la base de datos mediante MyBatis y MySQL.

## Links de las pantallas
- **Pantalla de bienvenida:** http://localhost:8081/tarea/
- **Pantalla para dar de alta una tarea:** http://localhost:8081/tarea/crear
- **Pantalla de listado de tareas dadas de alta:** http://localhost:8081/tarea/lista

## Tecnologías Usadas
- **Java 8**
- **Spring Boot MVC**
- **MyBatis (ORM)**
- **Bootstrap (Front-End)**
- **MySQL (Base de Datos)**
- **XAMPP** (para el servidor de MySQL)
- **Maven** (para gestión de dependencias)
- **Eclipse** (como entorno de desarrollo)

## Estructura del Proyecto
El proyecto sigue la arquitectura **MVC**:
- **Modelo**: Gestiona los datos y la lógica de negocio. Está implementado mediante clases en el paquete `model` y las interfaces de `MyBatis Mapper`.
- **Vista**: Las interfaces de usuario (UI) están en el paquete `templates` utilizando `Thymeleaf` y `Bootstrap` para renderizar las páginas HTML.
- **Controlador**: Las solicitudes HTTP son gestionadas por los controladores en el paquete `controller`, que manejan la lógica y deciden qué vistas mostrar o a qué servicios llamar.

### Módulos
- **PruebaJava**: Contiene la lógica de la aplicación, vistas, controladores y servicios.
  - `src/main/java/com/ejemplo/proyectoprueba/PruebaJavaApplication.java`: Clase principal del proyecto.
  - `src/main/resources/templates/`: Contiene las vistas `create.html`, `home.html` y `list.html`.
  - `src/main/java/com/ejemplo/proyectoprueba/controller/TareaController.java`: Controlador de tareas.
  - `src/main/java/com/ejemplo/proyectoprueba/service/`: Servicio de lógica de negocio.

- **datos - module**: Se encarga de la conexión a la base de datos.
  - `src/main/java/com/ejemplo/datos/config/MybatisConfig.java`: Configuración de MyBatis.
  - `src/main/java/com/ejemplo/datos/mapper/TareaMapper.java`: Interfaz Mapper para las consultas SQL.
  - `src/main/java/com/ejemplo/datos/model/`: Contiene los modelos de datos.

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/AdrianNicolas0405/PruebaJava8.git
