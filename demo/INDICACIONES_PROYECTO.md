# BCP - PROYECTO BACKEND

### Requisitos

Plugins que deben estar instalados en su IDE:
* [Lombok](http://projectlombok.org/) - *Libreria de Bytecode que genera automaticamente los Getters y Setters*.
* Java 8
---
Ejecutar DockerFile - Ambiente Linux

Creación de imagen docker
* sudo docker build -t bcp:1.0 .

Creación de contenedor con la imagen construida
* sudo docker run -d -p 9090:8080 --name bcp_container bcp:1.0
---
