-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema equipos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `equipos` ;

-- -----------------------------------------------------
-- Schema equipos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `equipos` DEFAULT CHARACTER SET utf8 ;
USE `equipos` ;

-- -----------------------------------------------------
-- Table `equipos`.`ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipos`.`ubicacion` (
  `id_ubicacion` INT NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_ubicacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipos`.`estatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipos`.`estatus` (
  `id_estatus` INT NOT NULL,
  `estatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipos`.`equipos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `equipos`.`equipos` (
  `idequipos` INT NOT NULL,
  `nombre_equipo` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `ubicacion_id_ubicacion` INT NOT NULL,
  `estatus_id_estatus` INT NOT NULL,
  PRIMARY KEY (`idequipos`),
  INDEX `fk_equipos_ubicacion_idx` (`ubicacion_id_ubicacion` ASC) VISIBLE,
  INDEX `fk_equipos_estatus1_idx` (`estatus_id_estatus` ASC) VISIBLE,
  CONSTRAINT `fk_equipos_ubicacion`
    FOREIGN KEY (`ubicacion_id_ubicacion`)
    REFERENCES `equipos`.`ubicacion` (`id_ubicacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipos_estatus1`
    FOREIGN KEY (`estatus_id_estatus`)
    REFERENCES `equipos`.`estatus` (`id_estatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
