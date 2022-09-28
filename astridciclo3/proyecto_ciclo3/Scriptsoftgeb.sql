SHOW DATABASES;
#Crear Base de datos
CREATE DATABASE proyecto_softgeb;
#Conectar a base de datos
USE proyecto_sofgeb;
#Crear tabla
CREATE TABLE equipos_biomedicos(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
nombre_equipo VARCHAR(100) NOT NULL,
marca VARCHAR(50) NOT NULL,
modelo VARCHAR(50) NOT NULL,
ubicacion VARCHAR(100) NOT NULL,
estatus VARCHAR(100) NOT NULL
);
# Mostrar tablas
SHOW TABLES;
DESCRIBE equipos_biomedicos;
 