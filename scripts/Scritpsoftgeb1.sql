SHOW DATABASES;
#Crear Base de datos
CREATE DATABASE softgeb;
#Conectar a base de datos
USE softgeb;
#Crear tabla
CREATE TABLE softgeb(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
nombre_equipo VARCHAR(100) NOT NULL,
marca VARCHAR(50) NOT NULL,
modelo VARCHAR(50) NOT NULL,
ubicacion VARCHAR(100) NOT NULL,
estatus VARCHAR(100) NOT NULL 
);
ALTER TABLE softgeb
add observacion TEXT NOT NULL;
# Mostrar tablas
SHOW TABLES;
DESCRIBE softgeb;
SELECT *FROM softgeb