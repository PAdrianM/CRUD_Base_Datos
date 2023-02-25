-- MySQL Script generated by MySQL Workbench
-- Mon Feb 20 13:09:47 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Municipio` (
  `idMunicipio` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Departamento_idDepartamento` INT NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  INDEX `fk_Municipio_Departamento1_idx` (`Departamento_idDepartamento` ASC) VISIBLE,
  CONSTRAINT `fk_Municipio_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `mydb`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Municipio_idMunicipio` INT NOT NULL,
  `CUI` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`idPersona`),
  INDEX `fk_Persona_Municipio1_idx` (`Municipio_idMunicipio` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_Municipio1`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `mydb`.`Municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tipos_Vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tipos_Vehiculo` (
  `idTipos_Vehiculo` INT NOT NULL,
  `Nombre` TEXT NULL,
  PRIMARY KEY (`idTipos_Vehiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vehiculos` (
  `idVehiculos` INT NOT NULL AUTO_INCREMENT,
  `Placa` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Persona_idPersona` INT NOT NULL,
  `Tipos_Vehiculo_idTipos_Vehiculo` INT NOT NULL,
  PRIMARY KEY (`idVehiculos`),
  INDEX `fk_Vehiculos_Persona_idx` (`Persona_idPersona` ASC) VISIBLE,
  INDEX `fk_Vehiculos_Tipos_Vehiculo1_idx` (`Tipos_Vehiculo_idTipos_Vehiculo` ASC) VISIBLE,
  UNIQUE INDEX `Placa_UNIQUE` (`Placa` ASC) VISIBLE,
  CONSTRAINT `fk_Vehiculos_Persona`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `mydb`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehiculos_Tipos_Vehiculo1`
    FOREIGN KEY (`Tipos_Vehiculo_idTipos_Vehiculo`)
    REFERENCES `mydb`.`Tipos_Vehiculo` (`idTipos_Vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;