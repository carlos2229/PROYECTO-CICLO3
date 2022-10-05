-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: entrada_salida
-- ------------------------------------------------------
-- Server version	5.7.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cargo_empleado` int(11) NOT NULL,
  `tipo_documento` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `identificacion` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `primer_nombre` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `segundo_nombre` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `primer_apellido` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `segundo_apellido` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `area_empleado` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `estado_empleado` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  KEY `id_cargo_empleado_idx` (`id_cargo_empleado`),
  CONSTRAINT `id_cargo_empleado` FOREIGN KEY (`id_cargo_empleado`) REFERENCES `cargos_empleados` (`id_cargo_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (27,4,'Cédula de ciudadanía','1','Edison','Fernando','Vera','Corredor','Operativo','Activo'),(29,1,'Tarjeta de identidad','2','Alvaro','Andres','Castillo','Hernandez','Operativo','Activo'),(30,1,'Tarjeta de identidad','3','Xiomara','Erika','Sanchez','Zuares','Operativo','Activo'),(31,1,'Cédula de ciudadanía','4','Wimar','Andres','Ruiz','Espitia','Operativo','Activo'),(36,4,'Cédula de ciudadanía','5','Juan','Felipe','Hernandez','Rojas','Operativo','Activo'),(37,2,'Tarjeta de identidad','6','Eider','salinas','salinas','salinas','Administrativo','Activo'),(38,2,'Cédula de ciudadanía','7','Diego','Mauricio','Tovar','Pascuas','Operativo','Activo'),(39,1,'Tarjeta de identidad','','','','','','Operativo','Activo');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 19:54:07