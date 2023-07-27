# DESAFIO ESCUELITA PREVIRED

## Comenzando 🚀

_La jerarquía de carpetas del proyecto debe respetar lo siguiente._

```
	-RAÍZ
		-> fuentes - Deja todo el código fuente del ejercicio.
		-> script - Script de inserción de schemas, tablas y data base del ejercicio.
```

## Instrucciones del ejercicio

El portal privado de PREVIRED ha decidido crear un nuevo módulo para sus clientes en empresas. Es por esto que se le ha solicitado al nuevo Desarrollador crear servicios Rest que permitan registrar la información de la(s) Empresa(s) con sus trabajadores activos asociados.

Los datos de la empresa a registrar son: Rut, Razón social, fecha inserción registro e identificador único por empresa. Por otra parte, para los trabajadores (Pueden ser más de uno) asociados a la empresa. Deberás registrar su Rut, Nombre, Apellido paterno, Apellido materno y Dirección física.

Adicionalmente, al momento de persistir se debe validar el rut (debes crear un algotirmo para aquello) y genera un algoritmo propio para el identificador único de la empresa de largo variable (10 a 50) "Se creativo para este generador de identificador único, la idea es que lo fabriques tú" (Usa las librerias que te dispone el JDK de Java). 

Como el producto es nuevo, deberás crear tu solución para una base de datos Postgres y tu servicio Rest con todas las acciones para las nuevas 2 tablas (CRUD completo con acciones: Crear registro, modificar, eliminar y obtener para ambas tablas Empresa y Trabajador(es)).

Requisito: Recordar que si eliminas una empresa debes eliminar el/los client(es).

Mucha suerte y danos tú mejor esfuerzo.

### Requisitos (Excluyente para el cupo) 📋

```
-> Se debe implementar la solución en Spring Boot, JPA/Hibernate, Maven.
-> Debes comentar tu código (Busca formas de buenas prácticas de SONAR).
-> El código debe ser escrito en Inglés o Español (NO AMBAS).
-> La solución debe contener un README.md con las instrucciones para compilar e instalar.
-> Hay bonus si usas SWAGGER (Opcional, no excluyente).
-> Enviar una copia Email a escueladetalentosti@previred.com y colocar en ASUNTO: "Postulación desafío PREVIRED". Para confirmar la finalización de la tarea y revisión.
-> Test unitarios en las secciones que estimes convenientes
```

## Entrega solución

+ La solución debe ser enviada vía un pull request a este repositorio "crea un Fork antes".
+ Dudas sobre el ejercicio a escueladetalentosti@previred.com

NOTA: Todos los pull request serán rechazados, esto no quiere decir que ha sido rechazada la solución, sino que es una forma de que otros postulantes no copien tu código.
