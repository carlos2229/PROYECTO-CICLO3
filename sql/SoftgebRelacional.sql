-- MySQL Workbench Forward Engineering
SET
    @OLD_UNIQUE_CHECKS = @ @UNIQUE_CHECKS,
    UNIQUE_CHECKS = 0;

SET
    @OLD_FOREIGN_KEY_CHECKS = @ @FOREIGN_KEY_CHECKS,
    FOREIGN_KEY_CHECKS = 0;

SET
    @OLD_SQL_MODE = @ @SQL_MODE,
    SQL_MODE = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Softgeb
-- -----------------------------------------------------
-- Base de datos inventario Equipo Biomedico
DROP SCHEMA IF EXISTS `Softgeb`;

-- -----------------------------------------------------
-- Schema Softgeb
--
-- Base de datos inventario Equipo Biomedico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Softgeb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

USE `Softgeb`;

-- -----------------------------------------------------
-- Table `Softgeb`.`ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Softgeb`.`ubicacion` (
    `id_ubicacion` INT NOT NULL AUTO_INCREMENT,
    `ubicacion` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id_ubicacion`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Softgeb`.`estatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Softgeb`.`estatus` (
    `id_estatus` INT NOT NULL AUTO_INCREMENT,
    `estatus` VARCHAR(50) NOT NULL,
    `observaciones` TEXT(100) NOT NULL,
    PRIMARY KEY (`id_estatus`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Softgeb`.`Softgeb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Softgeb`.`Softgeb` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nombre_equipo` VARCHAR(50) NOT NULL,
    `marca` VARCHAR(50) NOT NULL,
    `modelo` VARCHAR(50) NOT NULL,
    `ubicacion_id_ubicacion` INT NOT NULL,
    `estatus_id_estatus` INT NOT NULL,
    PRIMARY KEY (`id`, `estatus_id_estatus`),
    INDEX `fk_Equipos Biomedicos_ubicacion_idx` (`ubicacion_id_ubicacion` ASC) VISIBLE,
    INDEX `fk_equipos biomedicos_estatus1_idx` (`estatus_id_estatus` ASC) VISIBLE,
    CONSTRAINT `fk_Equipos Biomedicos_ubicacion` FOREIGN KEY (`ubicacion_id_ubicacion`) REFERENCES `Softgeb`.`ubicacion` (`id_ubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_equipos biomedicos_estatus1` FOREIGN KEY (`estatus_id_estatus`) REFERENCES `Softgeb`.`estatus` (`id_estatus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

SET
    SQL_MODE = @OLD_SQL_MODE;

SET
    FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;

SET
    UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;