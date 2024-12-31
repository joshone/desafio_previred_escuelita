# README

Este proyecto consta de **tres** pasos principales:

1. **Levantar contenedores con Docker Compose**  
2. **Descargar y levantar el servicio backend (desafio-java)**  
3. **Descargar y arrancar el proyecto React (desafio-previred)**

---

## Prerrequisitos

- [Docker](https://docs.docker.com/get-docker/)  
- [Docker Compose](https://docs.docker.com/compose/install/)  
- [Java 17 o superior](https://adoptium.net/temurin/releases/?version=17)  
- [Node.js y npm](https://nodejs.org/en/)

---

## 1. Ejecutar el `docker-compose`

1. Clona o descarga el repositorio que contiene los **scripts** (donde está el archivo `docker-compose.yml`).
2. Desde la carpeta raíz donde se encuentra el archivo `docker-compose.yml`, ejecuta en la terminal:

   ```bash
   docker-compose up -d
   ```

## 2. Compilar y ejecutar `desafio-java`
  este proyecto contiene spring boot, jpa y swagger, al levantar la aplicación se crearán las tablas necesarias


## 3. Compilar y ejecutar `desafio-previred`
  este proyecto está construido con react, axios y material-ui
