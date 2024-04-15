# lab8Microservicios

# Descripción 

El proyecto tiene como objetivo desarrollar una plataforma de microservicios al estilo de Twitter, donde los usuarios puedan crear hilos y publicaciones (posts) de manera sencilla. Este sistema estará diseñado para ser eficiente y escalable, utilizando tecnologías modernas como Quarkus, MongoDB y JWT (JSON Web Tokens).

## Video probando instancia EC2


## DESARROLLADO CON
* [Java version 17](https://www.oracle.com/co/java/technologies/downloads/) - Lenguaje de programación usado.
* [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias del proyecto
* [Git](https://git-scm.com/downloads) - Gestion de versiones del proyecto
* [QUARKUS](https://code.quarkus.io/) - Framework

## Pasos para ejecutar
1. Debemos clonar este repositorio
```bash
git clone https://github.com/Sebasian-Cepeda/lab8Microservicios.git
```
2. Hacemos un "cd" al repositorio clonado
```bash
cd lab8Microservicios
```
4. Compilamos el proyecto con el siguiente comando desde su IDE
```bash
./mvnw compile quarkus:dev
```
En caso de que no funcione puede intentar con este comando en su IDE
```bash
mvn compile quarkus:dev
```
En caso de que no funcione desde su IDE use el primer comando del paso 7 desde git bash

5. Escribimos el siguiente comando para crear un contenedor de Mongo desde docker el cual se necesita para este proyecto
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```
6. Ya podemos ingresar a la siguiente ruta desde nuestros brawser
```bash
http://localhost:8080/static/index.html
```
![image](https://github.com/Sebasian-Cepeda/lab8Microservicios/assets/89321404/186a32a9-4655-45ad-8d39-81e186e0eb88)

En el primer input podemos escribir el nombre de usuario para saber quien esta escribiende el post y luego daremos click en verify mientras que en el segundo input escribiremos el post en si y luego daremos click en send

![image](https://github.com/Sebasian-Cepeda/lab8Microservicios/assets/89321404/1809e6de-cb04-4722-ad25-c35e697cae6d)

como el usuario @forero no existe tenemos como respuesta undefined y debemos crearlo con postman

![image](https://github.com/Sebasian-Cepeda/lab8Microservicios/assets/89321404/41f2ca80-2094-47d9-91cd-bde5e9aa334a)

ahora podemos probar de nuevo

![image](https://github.com/Sebasian-Cepeda/lab8Microservicios/assets/89321404/71e86f9a-9968-4db6-b1be-abfd75585cdb)

podemos ver que el usuario ya existe y que el post se crea correctamente

# Diseño

Este repositorio inicialmente es un monolito con servicios que permiten crear hilos para publicar post al estilo twitter, teniendo presente la autenticación de usuarios, para posteriormente cambiar la arquitectura a microservicios con ayuda de AWS.

## AUTOR
Santiago Forero Yate
Juan Sebastian Cepeda saray
