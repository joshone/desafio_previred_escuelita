# DESAFIO PREVIRED

## Comenzando 🚀

_La jerarquía de carpetas del proyecto debe respetar lo siguiente._

```
	-RAÍZ
		-> fuentes - Deja todo el código fuente del ejercicio.
		-> script - Script de inserción de schemas, tablas y data base del ejercicio.
```

## Instrucciones del ejercicio
El portal privado de PREVIRED ha decidido crear un nuevo módulo para sus clientes en empresas. Es por esto que se le ha solicitado al nuevo Desarrollador crear servicios Rest que permitan registrar la información de la(s) Empresa(s) con sus trabajadores activos asociados y su respectivo FRONTEND.

## Backend:
Los datos de la empresa a registrar son: Rut, Razón social, fecha inserción registro e identificador único por empresa. Por otra parte, para los trabajadores (Pueden ser más de uno) asociados a la empresa. Deberás registrar su Rut, Nombre, Apellido paterno, Apellido materno y Dirección física.

Adicionalmente, al momento de persistir se debe validar el rut (debes crear un algotirmo para aquello) y genera un algoritmo propio para el identificador único de la empresa de largo variable (10 a 50) "Se creativo para este generador de identificador único, la idea es que lo fabriques tú" (Usa SOLO las librerias que te dispone el JDK de Java, Dates, Math, Random... etc). 

Como el producto es nuevo, deberás crear tu solución para una base de datos Postgres y tu servicio Rest con todas las acciones para las nuevas 2 tablas (CRUD completo con acciones: Crear registro, modificar, eliminar y obtener para ambas tablas Empresa y Trabajador(es)).

Requisito: Recordar que si eliminas una empresa debes eliminar el/los client(es).

## Frontend:  
El lenguaje puede ser cualquiera (se creativo), debe contener lo siguiente:
- La utilización de cada endpoint que generaste para el CRUD del backend.
- Registros tabulados de la empresa con sus respectivos trabajadores y acciones correspondientes.

Mucha suerte y danos tú mejor esfuerzo.

### Requisitos (Excluyente para el cupo) 📋

```
-> Se debe implementar la solución en Spring Boot, JPA/Hibernate, Maven.
-> Debes comentar tu código (Busca formas de buenas prácticas de SONAR).
-> El código debe ser escrito en Inglés o Español (NO AMBAS).
-> La solución debe contener un README.md con las instrucciones para compilar e instalar.
-> Hay bonus si usas SWAGGER (Opcional, no excluyente).
```

## Entrega solución

+ Sube tú código fuente a tu propio Github y envianos vía email el link público de tu solución.
+ Dudas sobre el ejercicio a yperez@previred.com ; rortiz@previred.com

